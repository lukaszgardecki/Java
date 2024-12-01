package com.example.przyklad_1.controller;

import com.example.przyklad_1.core.model.Task;
import com.example.przyklad_1.core.port.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping(
            path = "tasks",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public TaskDto createTask(TaskDto taskDto) {
        Task task = taskService.createTask(dtoToModel(taskDto));
        return modelToDto(task);
    }

    private Task dtoToModel(TaskDto taskDto) {
        return new Task(taskDto.id(), taskDto.name());
    }

    private TaskDto modelToDto(Task task) {
        return new TaskDto(task.id(), task.name());
    }
}
