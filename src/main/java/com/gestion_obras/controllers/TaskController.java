package com.gestion_obras.controllers;

import com.gestion_obras.models.entities.Project;
import com.gestion_obras.models.entities.Task;
import com.gestion_obras.services.task.TaskServiceManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskServiceManager taskServiceManager;

    @GetMapping
    @Transactional(readOnly = true)
    public List<Task> findAllTask() {
        return this.taskServiceManager.findAll();
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<Task> getByIdTask(@PathVariable Long id){
        return this.taskServiceManager.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Task saveTask(@RequestBody Task task) {
        return this.taskServiceManager.save(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody Task updatedTask) {
        Optional<Task> existingTask =  this.taskServiceManager.findById(id);

        if (existingTask.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Task task = existingTask.get();

        if (updatedTask.getStatus() != null) task.setStatus(updatedTask.getStatus());

        Task savedProject = this.taskServiceManager.save(task);
        return ResponseEntity.ok(savedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        boolean deleted = taskServiceManager.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
