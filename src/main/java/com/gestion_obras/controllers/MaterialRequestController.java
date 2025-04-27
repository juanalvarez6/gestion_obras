package com.gestion_obras.controllers;

import com.gestion_obras.models.dtos.materialrequest.MaterialRequestDto;
import com.gestion_obras.models.entities.Material;
import com.gestion_obras.models.entities.MaterialRequest;
import com.gestion_obras.models.entities.Project;
import com.gestion_obras.services.sevicesmanager.MaterialRequestServiceManager;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material-requests")
@Tag(name = "Solicitud de materiales", description = "Endpoint para la gestión de solicitudes de materiales")
public class MaterialRequestController {

    @Autowired
    private MaterialRequestServiceManager materialRequestServiceManager;

    @GetMapping
    @Transactional(readOnly = true)
    public List<MaterialRequest> findAll() {
        return this.materialRequestServiceManager.findAll();
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<MaterialRequest> getById(@PathVariable Long id) {
        return this.materialRequestServiceManager.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MaterialRequest create(@RequestBody MaterialRequestDto materialRequest) {
        MaterialRequest materialRequestNew = this.mapToMaterialRequest(materialRequest);
        return this.materialRequestServiceManager.save(materialRequestNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialRequest> update(@PathVariable Long id, @Valid @RequestBody MaterialRequestDto updatedMaterialRequest) {
        return this.materialRequestServiceManager.findById(id)
                .map(existingMaterialRequest -> {
                    MaterialRequest materialRequest = mapToMaterialRequest(updatedMaterialRequest);
                    materialRequest.setId(id);
                    MaterialRequest savedMaterialRequest = this.materialRequestServiceManager.save(materialRequest);
                    return ResponseEntity.ok(savedMaterialRequest);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterialRequest(@PathVariable Long id) {
        boolean deleted = materialRequestServiceManager.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    private MaterialRequest mapToMaterialRequest(MaterialRequestDto materialRequestDto) {
        MaterialRequest materialRequest = new MaterialRequest();

        if (materialRequestDto.getMaterialId() != null) {
            Material material = new Material();
            material.setId(materialRequestDto.getMaterialId());
            materialRequest.setMaterial(material);
        }

        if (materialRequestDto.getProjectId() != null) {
            Project project = new Project();
            project.setId(materialRequestDto.getProjectId());
            materialRequest.setProject(project);
        }

        if(materialRequestDto.getUserId() != null)
            materialRequest.setUserId(materialRequestDto.getUserId());

        materialRequest.setRequestedQuantity(materialRequestDto.getRequestedQuantity());

        if(materialRequestDto.getComments() != null)
            materialRequest.setComments(materialRequestDto.getComments());

        if(materialRequestDto.getStatus() != null)
            materialRequest.setStatus(materialRequestDto.getStatus());

        return materialRequest;
    }

}
