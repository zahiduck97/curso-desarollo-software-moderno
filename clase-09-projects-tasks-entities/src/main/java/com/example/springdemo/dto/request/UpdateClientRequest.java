package com.example.springdemo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateClientRequest(
        @NotBlank(message = "Name is required")
        String name,

        @Email(message = "Invalid Email")
        @NotBlank(message = "Email is required")
        String email
) {
}
