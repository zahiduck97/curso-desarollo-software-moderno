package com.example.springdemo.dto.request;

public record UpdateProjectRequest(
        String name,
        String description,
        String status
) {
}
