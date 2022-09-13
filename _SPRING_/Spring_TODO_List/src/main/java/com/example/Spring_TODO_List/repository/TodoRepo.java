package com.example.Spring_TODO_List.repository;

import com.example.Spring_TODO_List.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<TodoItem, Long> {
}
