package com.example.taskManagement.Security;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    @ConditionalOnProperty(name = "taskmanagement.security.enable" , havingValue = "false", matchIfMissing = true)
    public SecurityFilterChain openFilterChain(HttpSecurity http) throws Exception {
           http.authorizeHttpRequests(authz -> authz.anyRequest().permitAll()).csrf(csrf -> csrf.disable()).cors(cors -> cors.configurationSource(apiConfigurationSource()));

           return http.build();

    }


    @Bean
    @ConditionalOnProperty(name="taskmanagement.security.enable" , havingValue = "true" , matchIfMissing = false)
    public SecurityFilterChain secureFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/api/auth/register").permitAll().requestMatchers("/api/users/**").hasRole("ADMIN").anyRequest().authenticated()).httpBasic(Customizer.withDefaults()).csrf(csrf -> csrf.disable()).cors(cors -> cors.configurationSource((apiConfigurationSource())));

        return http.build();
    }

    private CorsConfigurationSource apiConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:4444"));
        configuration.setAllowedMethods(List.of("GET" , "PUT" , "DELETE" , "OPTIONS" , "POST"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**" , configuration);

        return source;
    }
}
