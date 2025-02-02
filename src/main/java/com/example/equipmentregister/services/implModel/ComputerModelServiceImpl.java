package com.example.equipmentregister.services.implModel;

import com.example.equipmentregister.dao.models.ComputerModelRepository;

public class ComputerModelServiceImpl{
    private final ComputerModelRepository computerModelRepository;

    public ComputerModelServiceImpl(ComputerModelRepository computerModelRepository) {
        this.computerModelRepository = computerModelRepository;
    }
}
