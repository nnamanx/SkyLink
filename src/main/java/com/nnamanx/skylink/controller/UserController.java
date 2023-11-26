package com.nnamanx.skylink.controller;

import com.nnamanx.skylink.model.entity.EndUser;
import com.nnamanx.skylink.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("${server.servlet.context-path}/api/v1/auth/user-ms")
public class UserController {

    private final UserService userService;

    @PostMapping("/authentication")
    public ResponseEntity<Map<String, String>> authenticateUser(@RequestBody Map<String, String> credentials) {

        // Implement authentication logic and generate JWT
        // Return access-token and refresh-token in the response
        return null;
    }

    @PostMapping("/renew-password/{username}")
    public ResponseEntity<Map<String, String>> renewPassword(

            @PathVariable String username,
            @RequestParam String token,
            @RequestBody Map<String, String> newPasswordRequest) {

        String newPassword = newPasswordRequest.get("newPassword");

        Optional<EndUser> user = userService.findByUsername(username);

        if (user == null || !userService.isValidResetToken(String.valueOf(user), token)) {

            Map<String, String> response = new HashMap<>();
            response.put("message", "Invalid username or token");
            return ResponseEntity.badRequest().body(response);
        }

        userService.updatePassword(String.valueOf(user), newPassword);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Password renewed successfully");
        return ResponseEntity.ok(response);

    }
}
