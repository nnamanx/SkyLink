package com.nnamanx.skylink.service;

import com.nnamanx.skylink.model.entity.EndUser;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.Optional;

public interface UserService {

    boolean isValidResetToken(String username, String token);

    ResponseEntity<Map<String, String>> updatePassword(String username, String newPassword);

    Optional<EndUser> findByUsername(String username);
    boolean confirmAccount(String confirmationToken);

}
