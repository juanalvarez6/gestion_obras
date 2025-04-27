package com.gestion_obras.controllers;

import com.gestion_obras.models.dtos.assignuserzone.AssignUserZoneDto;
import com.gestion_obras.models.entities.AssignUserZone;
import com.gestion_obras.models.entities.WorkZone;
import com.gestion_obras.services.sevicesmanager.AssignUserZoneServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assign_user_zones")
public class AssignUserZoneController {

    @Autowired
    private AssignUserZoneServiceManager assignUserZoneServiceManager;

    @GetMapping
    @Transactional(readOnly = true)
    public List<AssignUserZone> findAll() {
        return this.assignUserZoneServiceManager.findAll();
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<AssignUserZone> getById(@PathVariable Long id) {
        return this.assignUserZoneServiceManager.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public AssignUserZone create(@RequestBody AssignUserZoneDto assignUserZone) {
        AssignUserZone assignUserZoneNew = this.mapToAssignUserZone(assignUserZone);
        return this.assignUserZoneServiceManager.save(assignUserZoneNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssignUserZone> updateAssignUserZone(@PathVariable Long id, @Valid @RequestBody AssignUserZoneDto updatedAssignUserZone) {
        Optional<AssignUserZone> existingAssignUserZone = this.assignUserZoneServiceManager.findById(id);

        if (existingAssignUserZone.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        AssignUserZone assignUserZone = mapToAssignUserZone(updatedAssignUserZone);
        assignUserZone.setId(id);

        AssignUserZone savedAssignUserZone = this.assignUserZoneServiceManager.save(assignUserZone);
        return ResponseEntity.ok(savedAssignUserZone);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignUserZone(@PathVariable Long id) {
        boolean deleted = assignUserZoneServiceManager.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    public AssignUserZone mapToAssignUserZone(AssignUserZoneDto assignUserZoneDto) {
        AssignUserZone assignUserZone = new AssignUserZone();
        if (assignUserZoneDto.getUserId() != null) {
            assignUserZone.setUserId(assignUserZoneDto.getUserId());
        }
        if (assignUserZoneDto.getZoneId() != null) {
            WorkZone zone = new WorkZone();
            zone.setId(assignUserZoneDto.getZoneId());
            assignUserZone.setWorkZone(zone);
        }
        return assignUserZone;
    }

}
