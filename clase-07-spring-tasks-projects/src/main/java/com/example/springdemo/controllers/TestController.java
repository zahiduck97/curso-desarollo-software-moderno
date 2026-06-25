package com.example.springdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hola")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/hola/{name}")
    public String helloWorld(@PathVariable String name) {
        return "Hello " + name;
    }
}
