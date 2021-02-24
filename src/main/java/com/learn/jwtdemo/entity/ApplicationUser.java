package com.learn.jwtdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ApplicationUser {
    private int userId;
    private String userName;
    private String Password;
    private boolean isActive;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof String){
            if (this.userName.equals(obj)){
                return true;
            }
        }
        return false;
    }
}
