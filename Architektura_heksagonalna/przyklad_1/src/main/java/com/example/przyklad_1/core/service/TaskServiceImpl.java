package com.example.przyklad_1.core.service;

import com.example.przyklad_1.core.model.Task;
import com.example.przyklad_1.core.port.TaskRepo;
import com.example.przyklad_1.core.port.TaskService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;

    @Override
    public Task createTask(Task task) {
        return  taskRepo.saveTask(task);
    }
}
