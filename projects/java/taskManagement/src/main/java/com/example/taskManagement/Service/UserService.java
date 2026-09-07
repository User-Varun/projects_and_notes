package com.example.taskManagement.Service;

import com.example.taskManagement.Model.User;
import com.example.taskManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository ur;
    @Autowired
    private PasswordEncoder pe;


    public UserService(UserRepository ur){
        this.ur = ur;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = ur.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("username not found!"));

       return org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password(user.getPassword()).authorities(new SimpleGrantedAuthority(user.getRole())).disabled(!user.isEnabled()).build();
    }

    public User findUserByUsername(String username) throws UsernameNotFoundException {

        if(username == null) throw new  UsernameNotFoundException("Invalid username, username can't be empty!");

        return ur.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("invalid username!"));

    }

    @Transactional
    public User register(String username , String password) {

        if(username == null || password == null ) throw new InvalidUserException("username or password cannot be empty!");

        if (ur.findByUsername(username).isPresent())
            throw new RuntimeException("Username already exists");

        User user = new User();
        user.setUsername(username);
        user.setPassword(pe.encode(password));
        // by default role = user

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
