package com.namanx.security_ms.service.impl;

import com.namanx.security_ms.service.JwtService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

    @Override
    public Claims extractAllClaims(String jwt) {
        return null;
    }

    @Override
    public <T> T extractClaim(String jwt, Function<Claims, T> claimsResolved) {
        return null;
    }

    @Override
    public String extractUsername(String jwt) {
        return null;
    }

    @Override
    public Date extractExpiration(String jwt) {
        return null;
    }

    @Override
    public List<String> extractRoles(String token) {
        return null;
    }

    @Override
    public Key getSiginKey() {
        return null;
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return null;
    }

    @Override
    public String generateToken(UserDetails userDetails, Map<String, Object> extractClaims) {
        return null;
    }

    @Override
    public String generateRefreshToken(UserDetails userDetails) {
        return null;
    }

    @Override
    public String buildToken(UserDetails userDetails, Map<String, Object> extractClaims, long expiration) {
        return null;
    }

    @Override
    public boolean isTokenValid(String jwt, UserDetails userDetails) {
        return false;
    }
}
