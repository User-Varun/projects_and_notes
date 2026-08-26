package com.example.taskManagement.Controller;

import com.example.taskManagement.Dto.UserDto;
import com.example.taskManagement.Model.User;
import com.example.taskManagement.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService us;


    public UserController(UserService us){
        this.us = us;
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody UserDto u){

        User savedUser = us.save(u);

        URI location = URI.create("/api/users/" + savedUser.getId());

        return ResponseEntity
                .created(location)
                .body(savedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id){
        return ResponseEntity.ok().body(us.getUser(id));
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(us.getAllUsers());
    }
}
