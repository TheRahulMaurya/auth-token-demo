package com.learn.jwtdemo.service.impl;

import com.learn.jwtdemo.constants.APIConstants;
import com.learn.jwtdemo.entity.ApplicationUser;
import com.learn.jwtdemo.service.UserService;
import com.learn.jwtdemo.util.PasswordUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<ApplicationUser> getApplicationUser() {
        List<ApplicationUser> users = new ArrayList<>();
        try {
            users.add(new ApplicationUser(
                    1,
                    "rahul",
                    PasswordUtil.encrypt("Password", APIConstants.SECRET),
                    true));

            users.add(new ApplicationUser(
                    2,
                    "raghav",
                    PasswordUtil.encrypt("Password12", APIConstants.SECRET),
                    true));
            users.add(new ApplicationUser(
                    3,
                    "vendra",
                    PasswordUtil.encrypt("Password123", APIConstants.SECRET),
                    true));
        } catch (Exception ex) {
            Logger.getLogger(ex.getMessage());
            ex.printStackTrace();
        }
        return users;
    }
}
