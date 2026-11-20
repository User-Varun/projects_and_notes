package com.quickcommerce.engine.auth.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
