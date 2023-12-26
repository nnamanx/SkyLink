package com.namanx.clientms.repository;

import com.namanx.clientms.model.entity.Client;
import com.namanx.clientms.model.entity.Token;
import com.namanx.clientms.model.enums.TokenType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findByTokenValue(String tokenValue);

    Optional<Token> findByClientAndTokenType(Client client, TokenType tokenType);

}
