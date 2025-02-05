package com.example.equipmentregister.dao.models;

import com.example.equipmentregister.dao.BaseModelRepository;
import com.example.equipmentregister.models.models.SmartphoneModel;

import java.util.List;

public interface SmartphoneModelRepository extends BaseModelRepository<SmartphoneModel> {
    List<SmartphoneModel> findByMemory(int memory);
    List<SmartphoneModel> findByCamerasCount(int camerasCount);
}
