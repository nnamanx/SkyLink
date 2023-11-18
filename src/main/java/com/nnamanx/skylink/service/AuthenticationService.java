package com.nnamanx.skylink.service;

import com.nnamanx.skylink.model.dto.request.AuthenticationRequest;
import com.nnamanx.skylink.model.dto.request.UserRequest;
import com.nnamanx.skylink.model.dto.response.AuthenticationResponse;
import com.nnamanx.skylink.model.dto.response.GeneralResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface AuthenticationService {

    GeneralResponse register(UserRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
