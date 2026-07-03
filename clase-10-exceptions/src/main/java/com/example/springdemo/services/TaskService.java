package com.example.springdemo.services;

import com.example.springdemo.dto.request.CreateTaskRequest;
import com.example.springdemo.dto.request.UpdateTaskRequest;
import com.example.springdemo.dto.response.TaskDTO;
import com.example.springdemo.entities.Project;
import com.example.springdemo.entities.Task;
import com.example.springdemo.exceptions.ProjectNotFoundException;
import com.example.springdemo.repositories.ProjectRepository;
import com.example.springdemo.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public TaskService(
            TaskRepository taskRepository,
            ProjectRepository projectRepository
    ){
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    public List<TaskDTO> get() {
        return taskRepository.findAll()
                .stream()
                .map(this::convert)
                .toList();
    }

    public Optional<TaskDTO> getById(Long id) {
        return taskRepository.findById(id)
                .map(this::convert);
    }

    public TaskDTO post(CreateTaskRequest request){
        Project project = projectRepository.findById(request.projectId())
                .orElseThrow(() -> new ProjectNotFoundException(request.projectId()));

        Task task = Task.builder()
                .title(request.title())
                .Description(request.description())
                .project(project)
                .status(request.status())
                .build();

        Task taskSaved = taskRepository.save(task);

        return convert(taskSaved);
    }

    public Optional<TaskDTO> update(Long id, UpdateTaskRequest request) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(request.title());
                    task.setDescription(request.description());
                    task.setStatus(request.status());

                    Task taskUpdated = taskRepository.save(task);

                    return convert(taskUpdated);
                });

    }

    public boolean delete(Long id) {
        if (!taskRepository.existsById(id)) {
            return false;
        }

        taskRepository.deleteById(id);

        return true;
    }

    public TaskDTO convert(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getProject().getId(),
                task.getStatus()
        );
    }
}
