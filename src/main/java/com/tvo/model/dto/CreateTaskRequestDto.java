package com.tvo.model.dto;

public record CreateTaskRequestDto(
        String title,
        String description,
        String status) {
}
