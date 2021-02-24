package com.learn.jwtdemo;

import com.learn.jwtdemo.entity.ApplicationUser;
import com.learn.jwtdemo.service.UserService;
import com.learn.jwtdemo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@SpringBootApplication
public class JwtdemoApplication {

    public static List<ApplicationUser> users;

    public static void main(String[] args) {
        SpringApplication.run(JwtdemoApplication.class, args);
        // generates dummy users to perform operations
        users = new UserServiceImpl().getApplicationUser();
    }

}
