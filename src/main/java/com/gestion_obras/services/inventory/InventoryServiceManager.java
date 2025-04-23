package com.gestion_obras.services.inventory;

import com.gestion_obras.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceManager implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;
}
