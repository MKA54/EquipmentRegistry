package com.example.equipmentregister.dao.models;

import com.example.equipmentregister.dao.BaseModelRepository;
import com.example.equipmentregister.models.models.FridgeModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FridgeModelRepository extends BaseModelRepository<FridgeModel> {
    List<FridgeModel> findByDoorsCount(int doorsCount);
    List<FridgeModel> findByCompressorTypeLikeIgnoreCase(String compressorType);
}
