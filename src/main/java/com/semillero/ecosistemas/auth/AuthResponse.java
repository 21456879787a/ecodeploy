package com.semillero.ecosistemas.auth;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthResponse {
//    private User user;
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }
}
