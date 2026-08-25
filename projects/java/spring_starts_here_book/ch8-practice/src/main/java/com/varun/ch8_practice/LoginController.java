package com.varun.ch8_practice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LoginProcesser loginProcesser;


    public LoginController(LoginProcesser loginProcesser){
        this.loginProcesser = loginProcesser;
    }
    
    @GetMapping("/")
    public String login(){
      return "login.html";
    }

    @PostMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password , Model m){
        
        loginProcesser.setName(name);
        loginProcesser.setPassword(password);

        boolean loggedIn = loginProcesser.login();
        
        if(loggedIn){
            m.addAttribute("message" , "you are now logged in");
        }else{
            m.addAttribute("message" , "login Failed");
        }

        return "login.html";

    }
}
