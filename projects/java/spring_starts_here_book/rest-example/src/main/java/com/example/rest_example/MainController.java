package com.example.rest_example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello, Mani!";
    }
}
