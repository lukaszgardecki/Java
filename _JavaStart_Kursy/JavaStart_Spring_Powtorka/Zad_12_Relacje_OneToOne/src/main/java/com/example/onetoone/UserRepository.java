package com.example.onetoone;

import org.springframework.data.repository.CrudRepository;

interface UserRepository extends CrudRepository<User, Long> {
}
