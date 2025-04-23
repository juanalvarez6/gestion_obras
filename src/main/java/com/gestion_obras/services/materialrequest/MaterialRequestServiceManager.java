package com.gestion_obras.services.materialrequest;

import com.gestion_obras.repositories.MaterialRequestRepository;
import com.gestion_obras.services.material.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialRequestServiceManager implements MaterialService {

    @Autowired
    private MaterialRequestRepository materialRequestRepository;
}
