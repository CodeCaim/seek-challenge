package com.seek.candidatemanagement.application.dto.auth;

public class AuthResponse {
    
    private final String jwtToken;

    public AuthResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public static AuthResponse.AuthResponseBuilder builder() {
        return new AuthResponse.AuthResponseBuilder();
    }

    public static class AuthResponseBuilder {
        private String token;

        public AuthResponse.AuthResponseBuilder token(String token) {
            this.token = token;
            return this;
        }

        public AuthResponse build() {
            return new AuthResponse(token);
        }
    } 

    public String getJwtToken() {
        return jwtToken;
    }
}
