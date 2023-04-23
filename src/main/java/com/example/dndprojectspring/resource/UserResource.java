package com.example.dndprojectspring.resource;

import com.example.dndprojectspring.entity.User;
import com.example.dndprojectspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(
        name = "/users",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserResource {

    private UserService userService;

    @Autowired
    public UserResource(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Map> singUp(
            @RequestBody User user) {
        return new ResponseEntity<>((Map.of("message", userService.add(user.getUsername(), user.getEmail(), user.getPassword()))), HttpStatus.OK);
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