package com.example.springdemo.dto.request;

public record CreateTaskRequest(
        String title,
        String description,
        Long projectId,
        String status
) {
}