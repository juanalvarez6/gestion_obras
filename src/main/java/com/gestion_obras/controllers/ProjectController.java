package com.gestion_obras.controllers;

import com.gestion_obras.models.entities.Project;
import com.gestion_obras.services.project.ProjectServiceManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectServiceManager projectServiceManager;

    @GetMapping
    @Transactional(readOnly = true)
    public List<Project> findAllProjects() {
        return this.projectServiceManager.findAll();
    }

    @PostMapping
    public Project saveProject(@RequestBody Project project) {
        return this.projectServiceManager.save(project);
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<Project> getByIdProject(@PathVariable Long id){
        return this.projectServiceManager.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @Valid @RequestBody Project updatedProject) {
        Optional<Project> existingProject =  this.projectServiceManager.findById(id);

        if (existingProject.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Project project = existingProject.get();

        if (updatedProject.getStatus() != null) project.setStatus(updatedProject.getStatus());

        Project savedProject = this.projectServiceManager.save(project);
        return ResponseEntity.ok(savedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        boolean deleted = projectServiceManager.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}