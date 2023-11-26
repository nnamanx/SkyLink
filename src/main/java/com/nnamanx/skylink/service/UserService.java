package com.nnamanx.skylink.service;

import com.nnamanx.skylink.model.entity.EndUser;

import java.util.Optional;

public interface UserService {

    boolean isValidResetToken(String username, String token);

    void updatePassword(String username, String newPassword);

    Optional<EndUser> findByUsername(String username);

}
