package com.learn.jwtdemo.controller;

import com.learn.jwtdemo.JwtdemoApplication;
import com.learn.jwtdemo.dto.UserPrincipal;
import com.learn.jwtdemo.entity.ApplicationUser;
import com.learn.jwtdemo.security.CustomAuthenticationProvider;
import com.learn.jwtdemo.security.JwtTokenProvider;
import com.learn.jwtdemo.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    public static UserPrincipal logInUser = new UserPrincipal();

    @Autowired
    CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @GetMapping("/hello")
    public String hello(){
        return String.format("Welcome %s, Hello there!!", logInUser.getUsername());
    }

    @GetMapping("/users")
    public List<ApplicationUser> getUsers(){
        return JwtdemoApplication.users;
    }

    @PostMapping("/login")
    public String userLogin(@RequestBody ApplicationUser applicationUser){
        Logger.debug(this, "userLogin", applicationUser);
        Authentication authentication;
        try {
            authentication = customAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(
                    applicationUser.getUserName(),
                    applicationUser.getPassword()
            ));
            return jwtTokenProvider.generateToken(authentication);
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
