package com.learn.jwtdemo.security;

import com.learn.jwtdemo.constants.APIConstants;
import com.learn.jwtdemo.controller.UserController;
import com.learn.jwtdemo.dto.UserPrincipal;
import com.learn.jwtdemo.service.UserDetailService;
import com.learn.jwtdemo.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * This class will provide the necessary authentication at login.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserDetailService userDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        UserPrincipal userPrincipal = userDetailService.loadUserByUsername(username);
        if (userPrincipal == null) {
            throw new BadCredentialsException("Please enter valid credential.");
        }

        try {
            if (password.equals(PasswordUtil.decrypt(userPrincipal.getPassword(), APIConstants.SECRET))) {
                UserController.logInUser = userPrincipal;
                return new UsernamePasswordAuthenticationToken(userPrincipal, password, userPrincipal.getAuthorities());
            }else{
                throw new BadCredentialsException("Please enter valid credential.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new BadCredentialsException("Please enter valid credential.");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
