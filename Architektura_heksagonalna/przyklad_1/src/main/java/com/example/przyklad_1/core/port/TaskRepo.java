package com.example.przyklad_1.core.port;

import com.example.przyklad_1.core.model.Task;

public interface TaskRepo {
    Task saveTask(Task task);
}
