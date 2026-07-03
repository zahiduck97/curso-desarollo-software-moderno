package com.example.springdemo.dto.shared;

import java.time.LocalDateTime;

public record APIError(
        LocalDateTime timestamp,

        int status,

        String error,

        String message,

        String path
) {
}
