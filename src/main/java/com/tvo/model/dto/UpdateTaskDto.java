package com.tvo.model.dto;

public record UpdateTaskDto(
        String title,
        String description,
        String status) {
}
