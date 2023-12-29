package com.namanx.clientms.service;

import com.namanx.clientms.model.entity.Client;
import com.namanx.clientms.model.entity.Token;
import com.namanx.clientms.model.enums.TokenType;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TokenService {

    Token createToken(Client client, String token, TokenType tokenType, LocalDateTime expirationDate);

    Optional<Token> getToken(String tokenValue);

    Token updateToken(Long tokenId, String newTokenValue, LocalDateTime expirationDate);

    void deleteToken(String tokenValue);

    boolean validateToken(String tokenValue);
}
