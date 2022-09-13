package com.example.Spring_TODO_List.controller;

import com.example.Spring_TODO_List.model.TodoItem;
import com.example.Spring_TODO_List.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {

    @Autowired
    private TodoRepo todoRepo;

    @GetMapping
    public List<TodoItem> findAll() {
        return todoRepo.findAll();
    }

    @PostMapping
    public TodoItem save(@RequestBody TodoItem todoItem) {
        return todoRepo.save(todoItem);
    }

    @PutMapping
    public TodoItem update(@RequestBody TodoItem todoItem) {
        return todoRepo.save(todoItem);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        todoRepo.deleteById(id);
    }
}
