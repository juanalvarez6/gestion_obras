package com.gestion_obras.services.project;

import com.gestion_obras.models.entities.Project;
import com.gestion_obras.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceManager implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        return new ArrayList<>(this.projectRepository.findAll());
    }

    @Override
    public Optional<Project> findById(Long id)  {
        return this.projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return this.projectRepository.save(project);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
