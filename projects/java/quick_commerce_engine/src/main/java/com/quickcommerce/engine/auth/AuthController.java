package com.quickcommerce.engine.auth;

import com.quickcommerce.engine.auth.dto.LoginRequest;
import com.quickcommerce.engine.auth.dto.LoginResponse;
import com.quickcommerce.engine.auth.dto.RegisterRequest;
import com.quickcommerce.engine.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest req){
        authService.register(req);
        return  ResponseEntity.ok("user registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest req){
        LoginResponse result = authService.login(req.getEmail() , req.getPassword());

        return ResponseEntity.ok(Map.of("token" , result.getAccessToken()));
    }

    /*
    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@CookieValue(name = "refresh_token")  String refreshToken , HttpServletResponse httpServletResponse){

        if(refreshToken == null){
            return ResponseEntity.status(401).build();
        }

        return authService.refresh(refreshToken , httpServletResponse);

    }

     */
}
