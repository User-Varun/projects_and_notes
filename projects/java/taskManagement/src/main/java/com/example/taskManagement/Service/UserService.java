package com.example.taskManagement.Service;

import com.example.taskManagement.Dto.UserDto;
import com.example.taskManagement.InvalidUserException;
import com.example.taskManagement.Model.User;
import com.example.taskManagement.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    private UserRepository ur;


    public UserService(UserRepository ur){
        this.ur = ur;
    }

    public User save(UserDto u) {

        if(u == null) throw new InvalidUserException("User cannot be Null");

        User user = new User();
        user.setName(u.getName());

        return ur.save(user);
    };

    public User getUser(long id){

        return ur.findById(id)
                .orElseThrow(() ->
                        new InvalidUserException("User not found with id: " + id));
    }

    public List<User> getAllUsers(){
        return ur.findAll();
    }
}
