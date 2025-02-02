package com.example.equipmentregister.services.implModel;

import com.example.equipmentregister.dao.models.FridgeModelRepository;

public class FridgeServiceImpl {
    private final FridgeModelRepository fridgeModelRepository;

    public FridgeServiceImpl(FridgeModelRepository fridgeModelRepository) {
        this.fridgeModelRepository = fridgeModelRepository;
    }
}
