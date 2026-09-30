package com.example.taskManagement.Controller;

import com.example.taskManagement.Dto.LoginRequest;
import com.example.taskManagement.Dto.RegisterRequest;
import com.example.taskManagement.Dto.TokenResponse;
import com.example.taskManagement.Model.User;
import com.example.taskManagement.Security.JwtService;
import com.example.taskManagement.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService us;

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public UserController(UserService userService, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }


    @PostMapping("api/auth/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody RegisterRequest registerRequest){
        
        User user = us.register(registerRequest.getUsername() , registerRequest.getPassword());

        URI location = URI.create("/api/users/" + user.getId());

        return ResponseEntity
                .created(location)
                .body(user);
    }

    @PostMapping("api/auth/login")
    public ResponseEntity<TokenResponse> login(
            @Valid @RequestBody LoginRequest request
    ) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),
                                request.getPassword()
                        )
                );

        String token = jwtService.createAccessToken(authentication);

        return ResponseEntity.ok(new TokenResponse(token));
    }



    // Admin only
    @GetMapping("api/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id){
        return ResponseEntity.ok().body(us.getUser(id));
    }

    @GetMapping("api/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(us.getAllUsers());
    }
}
