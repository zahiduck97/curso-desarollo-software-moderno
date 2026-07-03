package com.example.springdemo.exceptions;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(Long id) {
        super("Project with ID: " + id + " Not Found");
    }
}
