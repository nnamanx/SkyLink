package com.nnamanx.skylink.controller;

import com.nnamanx.skylink.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("${server.servlet.context-path}//api/v1/auth/user-ms")
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

        // Implement logic to renew the password
        // Return response with a message
        return null;
    }

}
