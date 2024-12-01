package com.example.przyklad_1.adapter.persistence;

import com.example.przyklad_1.core.model.Task;
import com.example.przyklad_1.core.port.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskDatabaseRepo implements TaskRepo {

    private final TaskJpaRepo jpaRepo;

    @Override
    public Task saveTask(Task task) {
        TaskEntity entity = modelToEntity(task);
        return entityToModel(jpaRepo.save(entity));
    }

    private TaskEntity modelToEntity(Task task) {
        return TaskEntity.builder()
                .id(task.id())
                .name(task.name())
                .build();
    }

    private Task entityToModel(TaskEntity entity) {
        return new Task(entity.getId(), entity.getName());
    }
}
