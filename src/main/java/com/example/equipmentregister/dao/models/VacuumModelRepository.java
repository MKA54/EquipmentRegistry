package com.example.equipmentregister.dao.models;

import com.example.equipmentregister.dao.BaseModelRepository;
import com.example.equipmentregister.models.models.VacuumModel;

import java.util.List;

public interface VacuumModelRepository extends BaseModelRepository<VacuumModel> {
    List<VacuumModel> findByDustContainerVolume(double dustContainerVolume);

    List<VacuumModel> findByModesCount(int modesCount);
}
