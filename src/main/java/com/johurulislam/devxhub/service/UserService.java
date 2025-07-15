package com.johurulislam.devxhub.service;


import com.johurulislam.devxhub.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<?> saveUser(User user);

    public User findByUsername(String username);
}
