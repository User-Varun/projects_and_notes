package com.example.taskManagement.Controller;

import com.example.taskManagement.Dto.RegisterRequest;
import com.example.taskManagement.Model.User;
import com.example.taskManagement.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService us;


    @PostMapping("api/auth/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody RegisterRequest registerRequest){
        
        User user = us.register(registerRequest.getUsername() , registerRequest.getPassword());

        URI location = URI.create("/api/users/" + user.getId());

        return ResponseEntity
                .created(location)
                .body(user);
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
