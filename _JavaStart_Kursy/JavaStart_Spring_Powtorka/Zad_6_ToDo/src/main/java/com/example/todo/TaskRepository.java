package com.example.todo;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface TaskRepository {
    Task save(Task task);
    Optional<Task> findById(Long id);
}
