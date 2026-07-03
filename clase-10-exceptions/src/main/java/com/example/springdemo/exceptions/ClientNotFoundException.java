package com.example.springdemo.exceptions;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(Long id) {
        super("Client with ID: " + id + " Not Found");
    }
}
