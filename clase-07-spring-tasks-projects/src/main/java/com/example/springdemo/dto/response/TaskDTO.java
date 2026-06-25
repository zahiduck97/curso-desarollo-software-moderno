package com.example.springdemo.dto.response;

public record TaskDTO(
        Long id,
        String title,
        String Description,
        Long projectId,
        String status
) {
}
