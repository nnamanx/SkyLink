package com.namanx.clientms.service.impl;

import com.namanx.clientms.model.entity.Client;
import com.namanx.clientms.model.entity.Token;
import com.namanx.clientms.model.enums.TokenType;
import com.namanx.clientms.repository.TokenRepository;
import com.namanx.clientms.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

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
        return tokenRepository.findByTokenValue(tokenValue);
    }


}
