package com.example.przyklad_1.bootstrap;

import com.example.przyklad_1.core.port.TaskRepo;
import com.example.przyklad_1.core.port.TaskService;
import com.example.przyklad_1.core.service.TaskServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfiguration {

    @Bean
    public TaskService taskService(TaskRepo taskRepo) {
        return new TaskServiceImpl(taskRepo);
    }
}
