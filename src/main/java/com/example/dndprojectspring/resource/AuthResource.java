package com.example.dndprojectspring.resource;

import com.example.dndprojectspring.entity.User;
import com.example.dndprojectspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthResource {

    private UserService userService;

    @Autowired
    public AuthResource(UserService userService){
        this.userService = userService;
    }

    @PostMapping(path = "/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String singUp(User user) {
        return userService.add(user.getUsername(), user.getEmail(), user.getPassword());
    }

    @PostMapping(path = "/authenticate", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String singIn(User user) {
        return userService.authenticate(user.getEmail(), user.getPassword());
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}