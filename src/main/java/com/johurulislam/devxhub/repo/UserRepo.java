package com.johurulislam.devxhub.repo;

import com.johurulislam.devxhub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
