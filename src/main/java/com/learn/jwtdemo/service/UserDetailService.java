package com.learn.jwtdemo.service;

import com.learn.jwtdemo.JwtdemoApplication;
import com.learn.jwtdemo.dto.UserPrincipal;
import com.learn.jwtdemo.entity.ApplicationUser;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailService implements UserDetailsService {
    @Override
    public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPrincipal userPrincipal;
        for(ApplicationUser user : JwtdemoApplication.users){
            if(user.equals(username)){
                userPrincipal = new UserPrincipal();
                userPrincipal.setUserId(user.getUserId());
                userPrincipal.setUserName(user.getUserName());
                userPrincipal.setPassword(user.getPassword());
                userPrincipal.setActive(user.isActive());
                return userPrincipal;
            }
        }
        return null;
    }
}
