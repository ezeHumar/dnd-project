package com.example.dndprojectspring.service;

import com.example.dndprojectspring.entity.User;
import com.example.dndprojectspring.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserJpaRepository userRespository;

    @Autowired
    public UserService(UserJpaRepository userRepository){
        this.userRespository = userRepository;
    }

    public User add(String username, String email, String password) {
        User user = new User(username, email, password);
        userRespository.save(user);
        return user;
    }

    public boolean login(String email, String password) {
        Optional<User> user = userRespository.findByEmail(email);

        if (user.isEmpty()){
            return false;
        }

        User recoveredUser = user.get();

        if (!recoveredUser.getPassword().equals(password)){
            return false;
        }

        return true;
    }

    public List<User> getAllUsers(){
        return userRespository.findAll();
    }

}