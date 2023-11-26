package com.nnamanx.skylink.controller;

import com.nnamanx.skylink.model.dto.request.AuthenticationRequest;
import com.nnamanx.skylink.model.dto.request.UserRequest;
import com.nnamanx.skylink.model.dto.response.AuthenticationResponse;
import com.nnamanx.skylink.model.dto.response.GeneralResponse;
import com.nnamanx.skylink.service.AuthenticationService;
import com.nnamanx.skylink.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequiredArgsConstructor
@RequestMapping("${server.servlet.context-path}/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("/register")
    public GeneralResponse register(@RequestBody UserRequest request) {
        return authenticationService.register(request);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        authenticationService.refreshToken(request, response);
    }

    @GetMapping("/confirmation")
    public ResponseEntity<GeneralResponse> confirmAccount(@RequestParam("token") String confirmationToken) {
        boolean confirmationResult = userService.confirmAccount(confirmationToken);

        if (confirmationResult) {
            return ResponseEntity.ok(new GeneralResponse("Account confirmed successfully"));
        } else {
            return ResponseEntity.badRequest().body(new GeneralResponse("Invalid or expired confirmation token"));
        }
    }
}
