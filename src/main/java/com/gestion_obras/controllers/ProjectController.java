package com.gestion_obras.controllers;

import com.gestion_obras.models.dtos.project.ProjectDto;
import com.gestion_obras.models.entities.Project;
import com.gestion_obras.models.enums.StatusProject;
import com.gestion_obras.services.sevicesmanager.ProjectServiceManager;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@Tag(name = "Proyectos", description = "Endpoint para la gestión de proyectos")
public class ProjectController {

    @Autowired
    protected ProjectServiceManager projectServiceManager;

    @GetMapping
    @Transactional(readOnly = true)
    public List<Project> findAll() {
        return projectServiceManager.findAll();
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<Project> findById(@PathVariable Long id) {
        return projectServiceManager.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Project create(@RequestBody ProjectDto project) {
        Project projectNew = this.mapToProject(project);
        projectNew.setStatus(StatusProject.EN_PROGRESO);
        return projectServiceManager.save(projectNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> update(@PathVariable Long id, @Valid @RequestBody ProjectDto updatedProject) {
        return this.projectServiceManager.findById(id)
                .map(existingProject -> {
                    Project project = mapToProject(updatedProject);
                    project.setId(id);
                    Project savedProject = this.projectServiceManager.save(project);
                    return ResponseEntity.ok(savedProject);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Project> delete(@PathVariable Long id) {
        boolean deleted = projectServiceManager.delete(id);
        return deleted ? ResponseEntity.noContent().build(): ResponseEntity.notFound().build();
    }

    private Project mapToProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        if(projectDto.getName() != null) {
            project.setName(projectDto.getName());
        }
        if(projectDto.getDescription() != null) {
            project.setDescription(projectDto.getDescription());
        }
        if(projectDto.getLatitude() != null) {
            project.setLatitude(projectDto.getLatitude());
        }
        if(projectDto.getLongitude() != null) {
            project.setLongitude(projectDto.getLongitude());
        }
        if(projectDto.getStartDate() != null)
            project.setStartDate(projectDto.getStartDate());

        if(projectDto.getEndDate() != null)
            project.setEndDate(projectDto.getEndDate());

        return project;
    }

}