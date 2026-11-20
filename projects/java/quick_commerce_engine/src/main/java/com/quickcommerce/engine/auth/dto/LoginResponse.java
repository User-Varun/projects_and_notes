package com.quickcommerce.engine.auth.dto;

import com.quickcommerce.engine.user.model.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class LoginResponse {
     private User user;
     private String accessToken;

     public LoginResponse(User user , String accessToken){
          this.accessToken = accessToken;
          this.user = user;
     }
}
