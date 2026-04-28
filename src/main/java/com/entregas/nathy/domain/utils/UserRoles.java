package com.entregas.nathy.domain.utils;

import org.apache.catalina.User;

public enum UserRoles {
    ADMIN("admin"),
    USER("user");

    private String role;

     UserRoles(String role){
        this.role = role;
     }

     public String getRole(){
         return role;
     }
}
