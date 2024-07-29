package com.publiko.api.login.controller;

import com.publiko.api.login.dto.LoginRequest;
import com.publiko.api.login.dto.LoginResponse;
import com.publiko.api.login.service.LoginService;
import com.publiko.api.security.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final LoginService loginService;

    @PostMapping("/login")
    public LoginResponse AuthenticateAndGetToken(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }

}
