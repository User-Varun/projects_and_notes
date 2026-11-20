package com.quickcommerce.engine.auth.service;

import com.quickcommerce.engine.user.enums.Role;
import com.quickcommerce.engine.user.model.User;
import lombok.Data;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class CustomUserDetails implements UserDetails {

    private final Long id;
    private final String email;
    private final String password;
    private final String role;


    public CustomUserDetails(User user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.password  = user.getPassword_hash();
        this.role = user.getRole().name();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority("ROLE_" + role));
    }

    @Override
    public @Nullable String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    

}
