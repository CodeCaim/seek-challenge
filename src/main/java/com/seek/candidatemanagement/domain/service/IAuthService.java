package com.seek.candidatemanagement.domain.service;

import com.seek.candidatemanagement.application.dto.auth.AuthResponse;
import com.seek.candidatemanagement.application.dto.auth.LoginRequest;
import com.seek.candidatemanagement.application.dto.auth.RegisterRequest;

public interface IAuthService {
    AuthResponse login(LoginRequest request);
    AuthResponse register(RegisterRequest request);
}
