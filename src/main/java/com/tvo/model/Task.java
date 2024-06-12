package com.tvo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Task {
    private static int counter = 0;

    private int id;
    private String title;
    private String description;
    private TaskStatus status;

    public Task(String title, String description, TaskStatus status){
        this.id = ++counter;
        this.title = title;
        this.description = description;
        this.status = status;
    }
}
