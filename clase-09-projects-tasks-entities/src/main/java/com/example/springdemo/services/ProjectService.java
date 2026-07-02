package com.example.springdemo.services;

import com.example.springdemo.dto.request.CreateProjectRequest;
import com.example.springdemo.dto.request.UpdateProjectRequest;
import com.example.springdemo.dto.response.ProjectDTO;
import com.example.springdemo.entities.Project;
import com.example.springdemo.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(
            ProjectRepository projectRepository
    ) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectDTO> get() {

        return projectRepository.findAll()
                .stream()
                .map(this::convert)
                .toList();
    }

    public Optional<ProjectDTO> getById(Long id) {
        return projectRepository.findById(id)
                .map(this::convert);
    }

    public ProjectDTO post(CreateProjectRequest request){
        Project project = Project.builder()
                .name(request.name())
                .description(request.description())
                .description(request.description())
                .clientId(request.clientId())
                .status(request.status())
                .build();

        Project projectSaved = projectRepository.save(project);

        return convert(projectSaved);
    }

    public Optional<ProjectDTO> update(Long id, UpdateProjectRequest request) {
        return projectRepository.findById(id)
                .map(project -> {
                    project.setName(request.name());
                    project.setDescription(request.description());
                    project.setClientId(project.getClientId());
                    project.setStatus(request.status());

                    Project projectUpdated = projectRepository.save(project); //upsert

                    return convert(projectUpdated);
                });

    }

    public boolean delete(Long id) {
        if(!projectRepository.existsById(id)) {
            return false;
        }

        projectRepository.deleteById(id);

        return true;
    }

    public ProjectDTO convert(Project project) {
        return new ProjectDTO(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getClientId(),
                project.getStatus()
        );
    }
}
