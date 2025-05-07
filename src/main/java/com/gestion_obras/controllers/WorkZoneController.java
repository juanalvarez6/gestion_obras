package com.gestion_obras.controllers;

import com.gestion_obras.models.dtos.workzone.WorkZoneDto;
import com.gestion_obras.models.entities.Project;
import com.gestion_obras.models.entities.WorkZone;
import com.gestion_obras.models.enums.StatusWorkZone;
import com.gestion_obras.services.sevicesmanager.WorkZoneServiceManager;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/zones")
@Tag(name = "Zonas", description = "Endpoint para la gestión de zonas de trabajo")
public class WorkZoneController {

    @Autowired
    private WorkZoneServiceManager workZoneServiceManager;

    @GetMapping
    @Transactional(readOnly = true)
    public List<WorkZone> findAll() {
        return this.workZoneServiceManager.findAll();
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<WorkZone> getById(@PathVariable Long id){
        return this.workZoneServiceManager.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public WorkZone create(@RequestBody WorkZoneDto workZone) {
        WorkZone zoneNew = this.mapToZone(workZone);
        zoneNew.setStatus(StatusWorkZone.EN_PROGRESO);
        return this.workZoneServiceManager.save(zoneNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkZone> update(@PathVariable Long id, @Valid @RequestBody WorkZoneDto updatedWorkZone) {
        return this.workZoneServiceManager.findById(id)
                .map(existingWorkZone -> {
                    WorkZone zone = mapToZone(updatedWorkZone);
                    zone.setId(id);
                    WorkZone savedWorkZone = this.workZoneServiceManager.save(zone);
                    return ResponseEntity.ok(savedWorkZone);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = workZoneServiceManager.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    private WorkZone mapToZone(WorkZoneDto workZoneDto) {
        WorkZone workZone = new WorkZone();
        if (workZoneDto.getProjectId() != null) {
            Project project = new Project();
            project.setId(workZoneDto.getProjectId());
            workZone.setProject(project);
        }
        if (workZoneDto.getName() != null) {
            workZone.setName(workZoneDto.getName());
        }
        if (workZoneDto.getDescription() != null) {
            workZone.setDescription(workZoneDto.getDescription());
        }
        if (workZoneDto.getLatitude() != null) {
            workZone.setLatitude(workZoneDto.getLatitude());
        }
        if (workZoneDto.getLongitude() != null) {
            workZone.setLongitude(workZoneDto.getLongitude());
        }
        return workZone;
    }

}
