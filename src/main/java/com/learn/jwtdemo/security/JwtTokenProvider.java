package com.learn.jwtdemo.security;

import com.learn.jwtdemo.constants.APIConstants;
import com.learn.jwtdemo.dto.UserPrincipal;
import com.learn.jwtdemo.util.Logger;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    /**
     * Generates Jwt token
     * @param authentication
     * @return
     */
    public String generateToken(final Authentication authentication){
        Logger.info(this, "generateToken");
        final UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String authorities = null;
        if(userPrincipal.getAuthorities() != null){
            authorities= userPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(","));
        }
        Claims claims = Jwts.claims().setSubject(authentication.getName());
        claims.put("authorities", authorities);
        claims.put("isActive", userPrincipal.isActive());
        claims.put("userId", userPrincipal.getUserId());
        claims.put("username", userPrincipal.getUsername());
        final String token = Jwts.builder().addClaims(claims).signWith(SignatureAlgorithm.HS256, APIConstants.SECRET).compact();
        Logger.info("generateToken: "+token);
        return token;
    }
}
