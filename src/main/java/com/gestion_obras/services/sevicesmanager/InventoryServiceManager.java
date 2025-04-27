package com.gestion_obras.services.sevicesmanager;

import com.gestion_obras.models.entities.Inventory;
import com.gestion_obras.repositories.InventoryRepository;
import com.gestion_obras.services.GenericServiceManager;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceManager extends GenericServiceManager<Inventory, InventoryRepository> {
}
