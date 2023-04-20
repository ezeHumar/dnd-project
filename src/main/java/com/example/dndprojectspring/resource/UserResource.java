package com.example.dndprojectspring.resource;

import com.example.dndprojectspring.entity.User;
import com.example.dndprojectspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    private UserService userService;

    @Autowired
    public UserResource(UserService userService){
        this.userService = userService;
    }
//
//    @POST
//    @Path("/signup")
//    public User singUp(@FormParam("username") String username, @FormParam("email") String email, @FormParam("password") String password) {
//        return userService.add(username, email, password);
//    }
//
//    @POST
//    @Path("/login")
//    public String login(@FormParam("email") String email, @FormParam("password") String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
//        if (userService.login(email, password)){
//            return "Welcome!";
//        }
//
//        return "Email or password is incorrect";
//    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


}