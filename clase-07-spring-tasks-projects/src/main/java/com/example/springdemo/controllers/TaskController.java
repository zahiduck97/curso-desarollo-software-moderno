package com.example.springdemo.controllers;

import com.example.springdemo.dto.request.CreateTaskRequest;
import com.example.springdemo.dto.request.UpdateTaskRequest;
import com.example.springdemo.dto.response.TaskDTO;
import com.example.springdemo.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(
            TaskService clientService
    ){
        this.taskService = clientService;
    }

    // Routes

    @GetMapping
    public List<TaskDTO> get(){
        return taskService.get();
    }

    @GetMapping("/{id}")
    public TaskDTO getById(@PathVariable Long id) {
        return taskService.getById(id)
                .orElse(null);
    }

    @PostMapping
    public TaskDTO post(@RequestBody @Valid CreateTaskRequest request) {
        return taskService.post(request);
    }

    @PutMapping("/{id}")
    public TaskDTO update(
            @PathVariable Long id,
            @RequestBody @Valid UpdateTaskRequest request
    ) {
        return taskService.update(id, request)
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        boolean deleted = taskService.delete(id);

        if (deleted) {
            return "Client Deleted Successfully";
        }

        return "Client not found";

        /**
         return taskService.deleteClient(id)
         ? "Client Deleted Successfully"
         : "Client not found";
         **/
    }
}