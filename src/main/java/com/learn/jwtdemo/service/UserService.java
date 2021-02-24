package com.learn.jwtdemo.service;

import com.learn.jwtdemo.entity.ApplicationUser;
import org.springframework.stereotype.Service;
import java.util.List;

public interface UserService{

    /**
     * generates dummy users.
     * @return List of dummy users.
     */
    public List<ApplicationUser> getApplicationUser();
}
