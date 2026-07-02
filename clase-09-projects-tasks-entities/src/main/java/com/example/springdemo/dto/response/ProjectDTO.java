package com.example.springdemo.dto.response;

public record ProjectDTO(
        Long id,
        String name,
        String description,
        Long clientId,
        String status
) {
}
