package com.gestion_obras.services.assignuserzone;

import com.gestion_obras.repositories.AssignUserZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignUserZoneServiceManager implements AssignUserZoneService{

    @Autowired
    private AssignUserZoneRepository assignUserZoneRepository;
}