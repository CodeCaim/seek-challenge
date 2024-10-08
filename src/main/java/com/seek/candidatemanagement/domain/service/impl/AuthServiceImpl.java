package com.seek.candidatemanagement.domain.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.seek.candidatemanagement.application.dto.auth.AuthResponse;
import com.seek.candidatemanagement.application.dto.auth.LoginRequest;
import com.seek.candidatemanagement.application.dto.auth.RegisterRequest;
import com.seek.candidatemanagement.domain.model.Role;
import com.seek.candidatemanagement.domain.model.User;
import com.seek.candidatemanagement.domain.repository.UserRepository;
import com.seek.candidatemanagement.domain.service.IAuthService;
import com.seek.candidatemanagement.domain.service.IJwtService;

@Service
public class AuthServiceImpl implements IAuthService {    
    
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private IJwtService jwtService;
    private PasswordEncoder passwordEncoder;

     public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository, IJwtService jwtService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
            
        String token = jwtService.getToken(user);

        return AuthResponse.builder()
            .token(token)
            .build();
    }

    @Override
    public AuthResponse register(RegisterRequest request) {

        User user = User.builder()
        .username(request.getUsername())
        .password(passwordEncoder.encode( request.getPassword()))
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .country(request.getCountry())
        .role(Role.USER)
        .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
    }

}
