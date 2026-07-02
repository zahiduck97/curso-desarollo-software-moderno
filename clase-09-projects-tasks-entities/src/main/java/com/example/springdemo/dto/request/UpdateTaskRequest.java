package com.example.springdemo.dto.request;

public record UpdateTaskRequest(
        String title,
        String description,
        String status
) {
}
