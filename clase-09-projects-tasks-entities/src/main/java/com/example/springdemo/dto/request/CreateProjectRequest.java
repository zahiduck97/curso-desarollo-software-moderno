package com.example.springdemo.dto.request;

public record CreateProjectRequest(
        String name,
        String description,
        Long clientId,
        String status
) {
}
