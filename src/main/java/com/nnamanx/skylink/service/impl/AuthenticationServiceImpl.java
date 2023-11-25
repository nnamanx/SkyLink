package com.nnamanx.skylink.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nnamanx.skylink.model.dto.request.AuthenticationRequest;
import com.nnamanx.skylink.model.dto.request.UserRequest;
import com.nnamanx.skylink.model.dto.response.AuthenticationResponse;
import com.nnamanx.skylink.model.dto.response.GeneralResponse;
import com.nnamanx.skylink.model.entity.EndUser;
import com.nnamanx.skylink.model.entity.Token;
import com.nnamanx.skylink.model.enums.RoleType;
import com.nnamanx.skylink.model.enums.TokenType;
import com.nnamanx.skylink.repository.TokenRepository;
import com.nnamanx.skylink.repository.UserRepository;
import com.nnamanx.skylink.service.AuthenticationService;
import com.nnamanx.skylink.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.nnamanx.skylink.model.constant.Message.REGISTER_SUCCESSFULLY;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public GeneralResponse register(@NotNull UserRequest request) {
        EndUser user = EndUser.builder()
                .name(request.getName())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(RoleType.USER)
                .build();


        EndUser savedUser = userRepository.save(user);

//        String accessToken = jwtService.generateToken(user);
//        String refreshToken = jwtService.generateRefreshToken(user);
//        saveUserToken(savedUser, accessToken);

        return GeneralResponse.builder()
                .message(REGISTER_SUCCESSFULLY)
                .time(LocalDate.from(LocalDateTime.now().withNano(0)))
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(@NotNull AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        EndUser user = (EndUser) userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        String accessToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        revokedAllUserTokens(user);
        saveUserToken(user, accessToken);

        return AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }

        final String refreshToken = authHeader.substring(7);
        final String userEmail = jwtService.extractUsername(refreshToken);

        if (userEmail != null) {
            EndUser user = (EndUser) userRepository.findByEmail(userEmail)
                    .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + userEmail));

            if (jwtService.isTokenValid(refreshToken, user)) {
                String accessToken = jwtService.generateToken(user);
                revokedAllUserTokens(user);
                saveUserToken(user, accessToken);

                AuthenticationResponse authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();

                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }


    // helper
    private void saveUserToken(EndUser user, String jwtToken) {
        Token token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();

        tokenRepository.save(token);
    }

    private void revokedAllUserTokens(EndUser user) {
        List<Token> validUserTokens = tokenRepository.findAllValidTokensByUser(user.getId());

        if (validUserTokens.isEmpty()) return;

        validUserTokens.forEach(t -> {t.setExpired(true); t.setRevoked(true);});
        tokenRepository.saveAll(validUserTokens);
    }

}
