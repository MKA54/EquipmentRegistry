package com.example.equipmentregister.services.implModel;

import com.example.equipmentregister.dao.models.VacuumModelRepository;

public class VacuumCleanerServiceImpl {
    private final VacuumModelRepository vacuumModelRepository;

    public VacuumCleanerServiceImpl(VacuumModelRepository vacuumModelRepository) {
        this.vacuumModelRepository = vacuumModelRepository;
    }
}
