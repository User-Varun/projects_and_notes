package com.quickcommerce.engine.auth.service;

import com.quickcommerce.engine.common.exceptions.UserNotFoundException;
import com.quickcommerce.engine.user.model.User;
import com.quickcommerce.engine.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UserNotFoundException {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));;

    return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword_hash())
            .roles(user.getRole().name())
                .build();
    }
}
