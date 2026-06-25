package com.example.springdemo.dto.response;

public record ClientDTO(
        Long id,
        String name,
        String email,
        String phone
) {
}

