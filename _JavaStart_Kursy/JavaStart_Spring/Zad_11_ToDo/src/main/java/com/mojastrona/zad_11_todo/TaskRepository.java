package com.mojastrona.zad_11_todo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findAllByStartTimeIsNullOrderByPriorityDesc();
    List<Task> findAllByCompletionTimeIsNotNullOrderByCompletionTimeAsc();
}
