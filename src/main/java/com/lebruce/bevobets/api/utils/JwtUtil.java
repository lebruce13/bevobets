package com.lebruce.bevobets.api.utils;
import io.jsonwebtoken.*;
//import org.springframework.stereotype.Component;

public class JwtUtil {
    private String secret = "jwtSecretKey";

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}