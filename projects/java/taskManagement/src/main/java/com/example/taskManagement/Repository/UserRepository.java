package com.example.taskManagement.Repository;

import com.example.taskManagement.Model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users;

    public UserRepository(){
        this.users  = new ArrayList<>();
    }


    public User getUser(int id){
        for(User u : users){
            if(u.getId() == id){
                return u;
            }
        }

        return null;
    }
    public List<User> getUsers(){
        return users;
    }
    public User save(User u){

        users.add(u);
     return u;
    }

}
