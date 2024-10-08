package com.seek.candidatemanagement.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seek.candidatemanagement.application.dto.auth.AuthResponse;
import com.seek.candidatemanagement.application.dto.auth.LoginRequest;
import com.seek.candidatemanagement.application.dto.auth.RegisterRequest;
import com.seek.candidatemanagement.domain.service.IAuthService;
// import com.seek.candidatemanagement.domain.service.impl.AuthServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private IAuthService authService;
    
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }
}
