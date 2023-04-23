package com.example.dndprojectspring.service;

import com.example.dndprojectspring.entity.Role;
import com.example.dndprojectspring.entity.User;
import com.example.dndprojectspring.exception.NotFoundException;
import com.example.dndprojectspring.repository.UserJpaRepository;
import com.example.dndprojectspring.config.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserJpaRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    @Autowired
    public UserService(UserJpaRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public String add(String username, String email, String password) {
        User user = new User(username, email, password);
        user.setRole(Role.USER);
        user.isActive();
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return jwtToken;
    }
    public String authenticate(String email, String password){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        email,
                        password
                )
        );

        User user = userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException(null, null));
        String jwtToken = jwtService.generateToken(user);
        return jwtToken;
    }

    public boolean login(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);

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
        return userRepository.findAll();
    }

}