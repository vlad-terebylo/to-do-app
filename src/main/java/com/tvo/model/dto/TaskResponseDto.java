package com.tvo.model.dto;

import com.tvo.model.Task;
import lombok.Data;

@Data
public class TaskResponseDto {
    private int id;
    private String title;
    private String description;
    private String status;

    public TaskResponseDto(Task task){
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.status = task.getStatus().toString();
    }
}
