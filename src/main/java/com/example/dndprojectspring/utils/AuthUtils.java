package com.example.dndprojectspring.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthUtils {

    public String getAuthenticatedEmail(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
