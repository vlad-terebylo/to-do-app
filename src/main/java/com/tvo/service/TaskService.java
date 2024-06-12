package com.tvo.service;

import com.tvo.exception.CannotUpdateStatusException;
import com.tvo.model.Task;
import com.tvo.model.TaskStatus;
import com.tvo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    public Task getTaskById(int id) {
        return taskRepository.getTaskById(id);
    }

    public void addNewTask(Task task) {
        taskRepository.addNewTask(task);
    }

    public void updateExistingTask(int id, Task task) {
        taskRepository.updateExistingTask(id, task);
    }

    public void taskStatusChange(int id) {
        Task task = taskRepository.getTaskById(id);
        TaskStatus currentStatus = task.getStatus();
        taskRepository.updateTaskStatusById(id, currentStatus.next());
    }

    public void deleteTask(int id) {
        taskRepository.deleteTask(id);
    }

    public void updateTaskStatusById(int id, TaskStatus status) {
        taskRepository.updateTaskStatusById(id, status);
    }
}
