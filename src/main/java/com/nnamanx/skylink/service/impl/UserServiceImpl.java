package com.nnamanx.skylink.service.impl;

import com.nnamanx.skylink.model.entity.EndUser;
import com.nnamanx.skylink.repository.UserRepository;
import com.nnamanx.skylink.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean isValidResetToken(String username, String token) {

        Optional<EndUser> user = userRepository.findByUsername(username);
        return user.isPresent() && token.equals(user.get().getRefresh_token());
    }

    @Override
    public void updatePassword(String username, String newPassword) {
        Optional<EndUser> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            EndUser user = optionalUser.get();

            String hashedPassword = passwordEncoder.encode(newPassword);
            user.setPassword(hashedPassword);

            user.setRefresh_token(null);
            userRepository.save(user);
        } else {
            // Handle the case where the user is not found
        }
    }

    public Optional<EndUser> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
