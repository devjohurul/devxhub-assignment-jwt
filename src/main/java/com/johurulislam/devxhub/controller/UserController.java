package com.johurulislam.devxhub.controller;

import com.johurulislam.devxhub.model.User;
import com.johurulislam.devxhub.service.UserService;
import com.johurulislam.devxhub.service.implementation.LogInServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    public final UserService userService;
    public final LogInServiceImp logInService;

    public UserController(UserService userService, LogInServiceImp logInService) {
        this.userService = userService;
        this.logInService = logInService;
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return logInService.createToken(user);
    }

    @GetMapping("/user")
    public String userEndpoint() {
        return "This is a user endpoint";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "This is an admin endpoint";
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody User user) {

        return userService.saveUser(user);
    }

}
