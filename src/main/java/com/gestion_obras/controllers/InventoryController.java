package com.gestion_obras.controllers;

import com.gestion_obras.models.dtos.inventory.InventoryDto;
import com.gestion_obras.models.entities.Inventory;
import com.gestion_obras.models.entities.Material;
import com.gestion_obras.models.entities.Project;
import com.gestion_obras.services.sevicesmanager.InventoryServiceManager;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventories")
@Tag(name = "Inventarios", description = "Endpoint para la gestión de inventarios")
public class InventoryController {

    @Autowired
    private InventoryServiceManager inventoryServiceManager;

    @GetMapping
    @Transactional(readOnly = true)
    public List<Inventory> findAll() {
        return this.inventoryServiceManager.findAll();
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<Inventory> getById(@PathVariable Long id) {
        return this.inventoryServiceManager.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Inventory create(@RequestBody InventoryDto inventory) {
        Inventory inventoryNew = this.mapToInventory(inventory);
        return this.inventoryServiceManager.save(inventoryNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> update(@PathVariable Long id, @Valid @RequestBody InventoryDto updatedInventory) {
        return this.inventoryServiceManager.findById(id)
                .map(existingInventory -> {
                    Inventory inventory = mapToInventory(updatedInventory);
                    inventory.setId(id);
                    Inventory savedInventory = this.inventoryServiceManager.save(inventory);
                    return ResponseEntity.ok(savedInventory);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = inventoryServiceManager.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    private Inventory mapToInventory(InventoryDto inventoryDto) {
        Inventory inventory = new Inventory();
        if (inventoryDto.getProjectId() != null) {
            Project project = new Project();
            project.setId(inventoryDto.getProjectId());
            inventory.setProject(project);
        }
        if (inventoryDto.getMaterialId() != null) {
            Material material = new Material();
            material.setId(inventoryDto.getMaterialId());
            inventory.setMaterial(material);
        }
        inventory.setAvailableQuantity(inventoryDto.getAvailableQuantity());
        return inventory;
    }

}
