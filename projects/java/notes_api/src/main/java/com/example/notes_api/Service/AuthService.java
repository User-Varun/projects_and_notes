package com.example.notes_api.Service;

import com.example.notes_api.Dto.UserRequest;
import com.example.notes_api.Exception.InvalidRegisterRequestException;
import com.example.notes_api.Exception.UserNotFoundException;
import com.example.notes_api.Model.User;
import com.example.notes_api.Repository.AuthRepository;
import com.example.notes_api.Security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = authRepository
                .findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("No user found with the username: " + username));

        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password(user.getPassword()).authorities(new SimpleGrantedAuthority(user.getRole())).disabled(!user.isEnabled()).build();
    }

    @Transactional
    public User register(UserRequest userRequest){

        if(userRequest.getUsername() == null || userRequest.getPassword() == null) throw new InvalidRegisterRequestException("username and password fields can not be empty.");

        User user = new User();

        user.setUsername(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        // by default role is USER;

        return authRepository.save(user);
    };

    public String login(Authentication authentication){
       return jwtService.createAccessToken(authentication);
    }



}
