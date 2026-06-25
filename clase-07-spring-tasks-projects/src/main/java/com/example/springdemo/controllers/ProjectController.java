package com.example.springdemo.controllers;

import com.example.springdemo.dto.request.CreateProjectRequest;
import com.example.springdemo.dto.request.UpdateProjectRequest;
import com.example.springdemo.dto.response.ProjectDTO;
import com.example.springdemo.services.ProjectService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    
    private final ProjectService projectService;
    
    public ProjectController(
            ProjectService projectService
    ){
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectDTO> get(){
        return projectService.get();
    }

    @GetMapping("/{id}")
    public ProjectDTO getById(@PathVariable Long id) {
        return projectService.getById(id)
                .orElse(null);
    }

    @PostMapping
    public ProjectDTO post(@RequestBody @Valid CreateProjectRequest request) {
        return projectService.post(request);
    }

    @PutMapping("/{id}")
    public ProjectDTO update(
            @PathVariable Long id,
            @RequestBody @Valid UpdateProjectRequest request
    ) {
        return projectService.update(id, request)
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        boolean deleted = projectService.delete(id);

        if (deleted) {
            return "Client Deleted Successfully";
        }

        return "Client not found";

        /**
         return projectService.deleteClient(id)
         ? "Client Deleted Successfully"
         : "Client not found";
         **/
    }
}
