package com.example.springdemo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientRequest(
        // @NotBlank = no null, no "", no "     "
        @NotBlank(message = "The name is required")
        String name,

        @Email(message = "Invalid Email")
        @NotBlank(message = "The email is required")
        String email,

        @NotBlank(message = "The phone is required")
        String phone
) {
}
