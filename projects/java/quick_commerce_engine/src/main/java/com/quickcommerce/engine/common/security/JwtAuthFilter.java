package com.quickcommerce.engine.common.security;

import com.quickcommerce.engine.common.exceptions.JwtAuthException;
import com.quickcommerce.engine.common.exceptions.security.JwtUtil;
import com.quickcommerce.engine.user.repository.UserRepository;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Intercepts the incoming http request and valiidate the jwt token
 */
@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    // public paths ( will add more later)
    private final Set<String> PUBLIC_PATHS = new HashSet<>(List.of("/api/auth/login" ,"api/auth/register"));

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException , IOException{



        // check if it's one of the public paths
        String path = request.getServletPath();
        if(PUBLIC_PATHS.contains(path)){
            filterChain.doFilter(request , response);
            return;
        }

        // otherwise check if header is there
        final String authHeader = request.getHeader("Authorization");

        String jwt;
        String email = null;

        if(authHeader != null && authHeader.startsWith("Bearer ")){
           jwt = authHeader.substring(7);
            // extract email from jwt
            try{
                email = jwtUtil.extractEmail(jwt);
            }catch (JwtException ex){
               throw new JwtAuthException("Expired or invalid token");
            }
        }
        // load user and authenticate it and set it in security context
       if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){

           UserDetails userDetails = userDetailsService.loadUserByUsername(email);

           UsernamePasswordAuthenticationToken authToken =
                   new UsernamePasswordAuthenticationToken(userDetails , null , userDetails.getAuthorities());


           authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

           SecurityContextHolder.getContext().setAuthentication(authToken);

       }



       // move the filter chain
        filterChain.doFilter(request , response);

    }
}
