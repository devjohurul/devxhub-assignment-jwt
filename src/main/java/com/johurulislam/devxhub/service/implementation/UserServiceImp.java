package com.johurulislam.devxhub.service.implementation;

import com.johurulislam.devxhub.model.User;
import com.johurulislam.devxhub.repo.UserRepo;
import com.johurulislam.devxhub.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<?> saveUser(User user) {
        try {
            User existingUser = userRepo.findByUsername(user.getUsername());
            if (existingUser != null) {
                return ResponseEntity.badRequest().body("User already exists!");
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving user: " + e.getMessage());
        }
        return ResponseEntity.ok("User saved successfully");
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

}
