package com.example.springdemo.services;

import com.example.springdemo.dto.request.CreateTaskRequest;
import com.example.springdemo.dto.request.UpdateTaskRequest;
import com.example.springdemo.dto.response.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    // Simulacion DB
    private final List<TaskDTO> taskDB = new ArrayList<>();
    private Long nextId = 1L;

    public TaskService(){
        taskDB.add(new TaskDTO(
                nextId++,
                "Create Endpoint for clients",
                "Create GET and POST for Clients ",
                1L,
                "IN_PROGRESS"
        ));

        taskDB.add(new TaskDTO(
                nextId++,
                "Design Dashboard",
                "Make Initial Layout dashboard",
                2L,
                "PENDING"
        ));
    }

    public List<TaskDTO> get() {
        return taskDB;
    }

    public Optional<TaskDTO> getById(Long id) {
        return taskDB.stream()
                .filter(task -> task.id().equals(id))
                .findFirst();
    }

    public TaskDTO post(CreateTaskRequest request){
        TaskDTO newTask = new TaskDTO(
                nextId++,
                request.title(),
                request.description(),
                request.projectId(),
                request.status()
        );

        taskDB.add(newTask);

        return newTask;
    }

    public Optional<TaskDTO> update(Long id, UpdateTaskRequest request) {
        Optional<TaskDTO> task = getById(id);

        if (task.isEmpty()) {
            return Optional.empty();
        }

        TaskDTO taskUpdated = new TaskDTO(
                id,
                request.title(),
                request.description(),
                task.get().projectId(),
                request.status()
        );

        //taskDB.removeIf(p -> p.id().equals(id));
        delete(id);
        taskDB.add(taskUpdated);

        return Optional.of(taskUpdated);

    }

    public boolean delete(Long id) {
        return taskDB.removeIf(task -> task.id().equals(id));
    }
}
