package com.example.Spring_Boot_Security_JPA;

import com.example.Spring_Boot_Security_JPA.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
