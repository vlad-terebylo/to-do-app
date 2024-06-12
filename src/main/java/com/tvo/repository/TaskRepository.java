package com.tvo.repository;

import com.tvo.model.Task;
import com.tvo.model.TaskStatus;

import java.util.List;

public interface TaskRepository {
    List<Task> getAllTasks();

    Task getTaskById(int id);

    void addNewTask(Task task);

    void updateExistingTask(int id, Task task);

    void deleteTask(int id);

    void updateTaskStatusById(int id, TaskStatus status);
}
