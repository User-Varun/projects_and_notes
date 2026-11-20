package com.quickcommerce.engine.common.exceptions.security;


import com.quickcommerce.engine.user.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey SECRET_KEY;

    private final SecretKey REFRESH_KEY;

    private final long EXPIRATION_TIME = 1000 * 60 * 15;

    public JwtUtil(@Value("${jwt.secret}")  String secret , @Value("${jwt.refreshSecret}")  String refreshToken) {
        this.SECRET_KEY = Keys.hmacShaKeyFor(refreshToken.getBytes());
        this.REFRESH_KEY = Keys.hmacShaKeyFor(refreshToken.getBytes());

    }


    public String generateToken(User user){
            return Jwts.builder()
                    .setSubject(user.getEmail())
                    .claim("userId" , user.getId())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(SECRET_KEY)
                    .compact();
    }


    public Claims parseRefreshToken(String token){
          return Jwts.parserBuilder().setSigningKey(REFRESH_KEY).build().parseClaimsJws(token).getBody();
    }
}
