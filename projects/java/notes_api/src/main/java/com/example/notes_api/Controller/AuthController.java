package com.example.notes_api.Controller;


import com.example.notes_api.Dto.TokenResponse;
import com.example.notes_api.Dto.UserRequest;
import com.example.notes_api.Dto.UserResponse;
import com.example.notes_api.Model.User;
import com.example.notes_api.Service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody UserRequest userRequest){

        User u = authService.register(userRequest);

        UserResponse res = new UserResponse();

        res.setId(u.getId());
        res.setUsername(u.getUsername());
        res.setEnabled(u.isEnabled());
        res.setRole(u.getRole());

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody UserRequest userRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userRequest.getUsername(),
                        userRequest.getPassword()
                )
        );

        String token = authService.login(authentication);

        return ResponseEntity.ok(new TokenResponse(token));

    }

}
