package com.publiko.api.login.service;

import com.publiko.api.login.dto.LoginRequest;
import com.publiko.api.login.dto.LoginResponse;
import com.publiko.api.security.JwtService;
import com.publiko.api.user.entity.UserEntity;
import com.publiko.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public LoginResponse login(LoginRequest request) {
//        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
//            request.getId(), request.getPw());
//        Authentication authentication = authenticationManager.authenticate(authToken);
//
//        if (authentication.isAuthenticated()) {
//            return new LoginResponse(jwtService.GenerateToken(request.getId()));
//        } else {
//            log.error("Login failed - {}", request.getId());
//            throw new UsernameNotFoundException("invalid user request..!!");
//        }
        UserEntity user = userRepository.findByIdAndPw(request.getId(),
            request.getPw()).orElseThrow(() -> new UsernameNotFoundException("invalid request"));
        return new LoginResponse(jwtService.GenerateToken(user.getId()));
    }
}
