package com.johurulislam.devxhub.service.implementation;

import com.johurulislam.devxhub.model.User;
import com.johurulislam.devxhub.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LogInServiceImp {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public LogInServiceImp(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public String createToken(User user) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                    user.getUsername(), user.getPassword()));

        } catch (Exception e) {
            throw new RuntimeException("Incorrect credentials!" + e.getMessage());
        }
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwtToken = jwtUtil.generateToken(userDetails);
        return jwtToken;
    }

}
