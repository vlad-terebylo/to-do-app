package com.tvo.controller;

import com.tvo.exception.TaskStatusIsNotSupportedException;
import com.tvo.model.Task;
import com.tvo.model.TaskStatus;
import com.tvo.model.dto.ChangeStatusRequestDto;
import com.tvo.model.dto.CreateTaskRequestDto;
import com.tvo.model.dto.TaskResponseDto;
import com.tvo.model.dto.UpdateTaskDto;
import com.tvo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<TaskResponseDto> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return tasks.stream()
                .map(TaskResponseDto::new)
                .toList();
    }

    @GetMapping("/{id}")
    public TaskResponseDto getTaskById(@PathVariable int id) {
        return new TaskResponseDto(taskService.getTaskById(id));
    }

    @PostMapping
    public void addNewTask(@RequestBody CreateTaskRequestDto requestDto) {
        TaskStatus taskStatus = TaskStatus.valueOf(requestDto.status().toUpperCase());
        Task task = new Task(requestDto.title(), requestDto.description(), taskStatus);
        taskService.addNewTask(task);
    }

    @PutMapping("/{id}")
    public void updateExistingTask(
            @PathVariable int id,
            @RequestBody UpdateTaskDto requestDto) {
        TaskStatus taskStatus = TaskStatus.valueOf(requestDto.status().toUpperCase());
        Task task = new Task(requestDto.title(), requestDto.description(), taskStatus);
        taskService.updateExistingTask(id, task);
    }

    @PatchMapping("/{id}")
    public void updateTaskStatusById(@PathVariable int id, @RequestBody ChangeStatusRequestDto request) {
        TaskStatus taskStatus = TaskStatus.valueOf(request.status().toUpperCase());
        taskService.updateTaskStatusById(id, taskStatus);
    }

    @PatchMapping("/status/next/{id}")
    public void taskStatusChange(@PathVariable int id){
        taskService.taskStatusChange(id);
    }


    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
    }
}

