package com.example.equipmentregister.services.implModel;

import com.example.equipmentregister.dao.models.SmartphoneModelRepository;

public class SmartphoneServiceImpl {
    private final SmartphoneModelRepository smartphoneModelRepository;

    public SmartphoneServiceImpl(SmartphoneModelRepository smartphoneModelRepository) {
        this.smartphoneModelRepository = smartphoneModelRepository;
    }
}
