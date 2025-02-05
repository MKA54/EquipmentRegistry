package com.example.equipmentregister.dao.models;

import com.example.equipmentregister.dao.BaseModelRepository;
import com.example.equipmentregister.models.models.ComputerModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerModelRepository extends BaseModelRepository<ComputerModel> {
    List<ComputerModel> findByCategoryLikeIgnoreCase(String category);
    List<ComputerModel> findByProcessorTypeLikeIgnoreCase(String processorType);
}
