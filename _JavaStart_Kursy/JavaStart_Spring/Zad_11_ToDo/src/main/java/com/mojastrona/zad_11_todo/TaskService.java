package com.mojastrona.zad_11_todo;

import com.mojastrona.zad_11_todo.dto.NewTaskDto;
import com.mojastrona.zad_11_todo.dto.TaskDurationDto;
import com.mojastrona.zad_11_todo.exception.TaskAlreadyCompletedException;
import com.mojastrona.zad_11_todo.exception.TaskAlreadyStartedException;
import com.mojastrona.zad_11_todo.exception.TaskNotFoundException;
import com.mojastrona.zad_11_todo.exception.TaskNotStartedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private static long nextId = 1;
    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional
    public Long saveTask(NewTaskDto task) {
        Task taskToSave = new Task(task.getTitle(), task.getDescription(), task.getPriority());
        taskToSave.setId(nextId);
        Task savedTask = taskRepository.save(taskToSave);
        nextId++;
        return savedTask.getId();
    }

    public Optional<String> getTaskInfo(Long taskId) {
        return taskRepository.findById(taskId).map(Task::toString);
    }

    @Transactional
    public LocalDateTime startTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(TaskNotFoundException::new);
        if (task.getStartTime() != null) {
            throw new TaskAlreadyStartedException();
        }
        task.setStartTime(LocalDateTime.now());
        return task.getStartTime();
    }

    @Transactional
    public TaskDurationDto completeTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(TaskNotFoundException::new);
        if (task.getStartTime() == null) {
            throw new TaskNotStartedException();
        } else if (task.getCompletionTime() != null) {
            throw new TaskAlreadyCompletedException();
        }
        task.setCompletionTime(LocalDateTime.now());
        return new TaskDurationDto(task.getStartTime(), task.getCompletionTime());
    }

    List<String> getAllNotStartedTasksInfo() {
        return taskRepository.findAllByStartTimeIsNullOrderByPriorityDesc()
                .stream()
                .map(Task::toString)
                .toList();
    }

    List<String> getAllCompletedTasksInfo() {
        return taskRepository.findAllByCompletionTimeIsNotNullOrderByCompletionTimeAsc()
                .stream()
                .map(Task::toString)
                .toList();
    }
}
