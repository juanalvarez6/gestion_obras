package com.gestion_obras.controllers;

import com.gestion_obras.models.entities.WorkZone;
import com.gestion_obras.services.workzone.WorkZoneServiceManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/zones")
public class WorkZoneController {

    @Autowired
    private WorkZoneServiceManager workZoneServiceManager;

    @GetMapping
    @Transactional(readOnly = true)
    public List<WorkZone> findAllWorkZone() {
        return this.workZoneServiceManager.findAll();
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<WorkZone> getByIdWorkZone(@PathVariable Long id){
        return this.workZoneServiceManager.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public WorkZone saveWorkZone(@RequestBody WorkZone workZone) {
        return this.workZoneServiceManager.save(workZone);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkZone> updateWorkZone(@PathVariable Long id, @Valid @RequestBody WorkZone updatedWorkZone) {
        Optional<WorkZone> existingWorkZone =  this.workZoneServiceManager.findById(id);

        if (existingWorkZone.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        WorkZone workZone = existingWorkZone.get();


        if (updatedWorkZone.getName() != null) workZone.setName(updatedWorkZone.getName());
        if (updatedWorkZone.getDescription() != null) workZone.setDescription(updatedWorkZone.getDescription());
        if (updatedWorkZone.getLatitude() != null) workZone.setLatitude(updatedWorkZone.getLatitude());
        if (updatedWorkZone.getLongitude() != null) workZone.setLongitude(updatedWorkZone.getLongitude());
        if (updatedWorkZone.getStatus() != null) workZone.setStatus(updatedWorkZone.getStatus());
        if (updatedWorkZone.getProject() != null) workZone.setProject(updatedWorkZone.getProject());


        WorkZone savedWorkZone = this.workZoneServiceManager.save(workZone);
        return ResponseEntity.ok(savedWorkZone);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkZone(@PathVariable Long id) {
        boolean deleted = workZoneServiceManager.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
