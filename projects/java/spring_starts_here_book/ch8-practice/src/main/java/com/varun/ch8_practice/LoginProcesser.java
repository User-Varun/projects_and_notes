package com.varun.ch8_practice;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcesser {
    
   private String name;
   private String password;

    public String getName() {
    return name;
}

   public void setName(String name) {
    this.name = name;
   }

   public String getPassword() {
    return password;
   }

   public void setPassword(String password) {
    this.password = password;
   }

    public boolean login(){

        

        if("varun".equals(this.getName()) && "123".equals(this.getPassword())){
            return true;
        }else{
            return false;
        }
    }
}
