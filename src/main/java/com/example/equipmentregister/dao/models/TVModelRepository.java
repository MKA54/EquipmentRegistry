package com.example.equipmentregister.dao.models;

import com.example.equipmentregister.dao.BaseModelRepository;
import com.example.equipmentregister.models.models.TVModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TVModelRepository extends BaseModelRepository<TVModel> {
    List<TVModel> findByCategoryLikeIgnoreCase(String category);
    List<TVModel> findByTechnologyLikeIgnoreCase(String technology);
}
