package com.example.taskManagement.Controller;

import com.example.taskManagement.Model.User;
import com.example.taskManagement.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService us;


    public UserController(UserService us){
        this.us = us;
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User u){

        URI location  = URI.create("/api/users/" + u.getId());
        return ResponseEntity.created(location).body(us.save(u));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id){
        return ResponseEntity.ok().body(us.getUser(id));
    }
}
