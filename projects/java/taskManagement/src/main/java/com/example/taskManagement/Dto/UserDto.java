package com.example.taskManagement.Dto;

import com.example.taskManagement.Model.User;
import jakarta.transaction.Transactional;

public class UserDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDto(){

  }
}
