package com.gestion_obras.services.material;

import com.gestion_obras.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceManager implements MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

}