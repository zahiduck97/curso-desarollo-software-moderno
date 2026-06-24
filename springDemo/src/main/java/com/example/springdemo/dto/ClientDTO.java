package com.example.springdemo.dto;

public record ClientDTO(
        Long id,
        String name,
        String email,
        String phone
) {
}

