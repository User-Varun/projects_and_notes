package com.example.taskManagement.Service;

import com.example.taskManagement.Model.User;
import com.example.taskManagement.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository ur;


    public UserService(UserRepository ur){
        this.ur = ur;
    }

    public User save(User u){
        return ur.save(u);
    };

    public User getUser(int id){
        return ur.getUser(id);
    }

    public List<User> getAllUsers(){
        return ur.getUsers();
    }
}
