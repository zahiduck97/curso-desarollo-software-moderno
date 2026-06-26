package com.example.springdemo.services;

import com.example.springdemo.dto.request.CreateProjectRequest;
import com.example.springdemo.dto.request.UpdateProjectRequest;
import com.example.springdemo.dto.response.ProjectDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    // Simulacion DB
    private final List<ProjectDTO> projectsDB = new ArrayList<>();
    private Long nextId = 1L;

    public ProjectService(){
        projectsDB.add(new ProjectDTO(
                nextId++,
                "CRM System",
                "App to manage clients and tasks ",
                1L,
                "ACTIVO"
        ));

        projectsDB.add(new ProjectDTO(
                nextId++,
                "Internal Portfolio",
                "Administrative portal for employees",
                2L,
                "IN_PROGRESS"
        ));
    }

    public List<ProjectDTO> get() {
        return projectsDB;
    }

    public Optional<ProjectDTO> getById(Long id) {
        return projectsDB.stream()
                .filter(project -> project.id().equals(id))
                .findFirst();
    }

    public ProjectDTO post(CreateProjectRequest request){
        ProjectDTO newProject = new ProjectDTO(
                nextId++,
                request.name(),
                request.description(),
                request.clientId(),
                request.status()
        );

        projectsDB.add(newProject);

        return newProject;
    }

    public Optional<ProjectDTO> update(Long id, UpdateProjectRequest request) {
        Optional<ProjectDTO> project = getById(id);

        if (project.isEmpty()) {
            return Optional.empty();
        }

        ProjectDTO projectUpdated = new ProjectDTO(
                id,
                request.name(),
                request.description(),
                project.get().clientId(),
                request.status()
        );

        //projectsDB.removeIf(p -> p.id().equals(id));
        delete(id);
        projectsDB.add(projectUpdated);

        return Optional.of(projectUpdated);

    }

    public boolean delete(Long id) {
        return projectsDB.removeIf(project -> project.id().equals(id));
    }
}
