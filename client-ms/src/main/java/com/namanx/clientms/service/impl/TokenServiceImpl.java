package com.namanx.clientms.service.impl;

import com.namanx.clientms.model.entity.Client;
import com.namanx.clientms.model.entity.Token;
import com.namanx.clientms.model.enums.TokenType;
import com.namanx.clientms.repository.TokenRepository;
import com.namanx.clientms.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.namanx.clientms.model.constant.Constants.TOKEN_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;

    @Override
    public Token createToken(Client client, String tokenValue, TokenType tokenType, LocalDateTime expirationDate) {

        Token token = Token.builder()
                .token(tokenValue)
                .tokenType(tokenType)
                .expirationDate(expirationDate)
                .client(client)
                .build();

        return tokenRepository.save(token);
    }

    @Override
    public Optional<Token> getToken(String tokenValue) {

        return tokenRepository.findByToken(tokenValue);
    }

    @Override
    public Token updateToken(Long tokenId, String newTokenValue, LocalDateTime expirationDate) {

        return tokenRepository.findById(tokenId).map(token -> {
            token.setToken(newTokenValue);
            token.setExpirationDate(expirationDate);
            return tokenRepository.save(token);
        }).orElseThrow(() -> new RuntimeException(TOKEN_NOT_FOUND));
    }

    @Override
    public void deleteToken(String tokenValue) {

        tokenRepository.findByToken(tokenValue).ifPresent(tokenRepository::delete);
    }

    @Override
    public boolean validateToken(String tokenValue) {

        Optional<Token> token = tokenRepository.findByToken(tokenValue);
        return token.map(value -> value.getExpirationDate().isAfter(LocalDateTime.now())).orElse(false);
    }


}
