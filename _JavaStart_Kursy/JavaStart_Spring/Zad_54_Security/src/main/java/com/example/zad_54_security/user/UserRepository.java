package com.example.zad_54_security.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
