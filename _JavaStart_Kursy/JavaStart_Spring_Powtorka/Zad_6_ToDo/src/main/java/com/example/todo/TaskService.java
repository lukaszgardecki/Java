package com.example.todo;

import com.example.todo.dto.NewTaskDto;
import com.example.todo.dto.TaskDurationDto;
import com.example.todo.exception.TaskAlreadyCompletedException;
import com.example.todo.exception.TaskAlreadyStartedException;
import com.example.todo.exception.TaskNotFoundException;
import com.example.todo.exception.TaskNotStartedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Long saveTask(NewTaskDto task) {
        Task taskToSave = new Task(task.getTitle(), task.getDescription(), task.getPriority());
        Task savedTask = repository.save(taskToSave);
        return savedTask.getId();
    }

    public Optional<String> getTaskInfo(Long taskId) {
        return repository.findById(taskId).map(Task::toString);
    }

    @Transactional
    public LocalDateTime startTask(Long taskId) {
        Task task = repository.findById(taskId)
                .orElseThrow(TaskNotFoundException::new);
        if (task.getStartTime() != null) {
            throw new TaskAlreadyStartedException();
        }
        task.setStartTime(LocalDateTime.now());
        return task.getStartTime();
    }

    @Transactional
    public TaskDurationDto completeTask(Long taskId) {
        Task task = repository.findById(taskId)
                .orElseThrow(TaskNotFoundException::new);
        if (task.getStartTime() == null) {
            throw new TaskNotStartedException();
        } else if (task.getCompletionTime() != null) {
            throw new TaskAlreadyCompletedException();
        }
        task.setCompletionTime(LocalDateTime.now());
        return new TaskDurationDto(task.getStartTime(), task.getCompletionTime());
    }

    public List<String> getAllNotStartedTasksInfo() {
        return repository.findAllByStartTimeIsNullOrderByPriorityDesc()
                .stream()
                .map(Task::toString)
                .toList();
    }

    public List<String> getAllCompletedTasks() {
        return repository.findAllByCompletionTimeIsNotNullOrderByCompletionTimeDesc()
                .stream()
                .map(Task::toString)
                .toList();
    }


}
