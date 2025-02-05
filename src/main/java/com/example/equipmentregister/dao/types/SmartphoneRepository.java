package com.example.equipmentregister.dao.types;

import com.example.equipmentregister.dao.BaseTypeRepository;
import com.example.equipmentregister.models.types.Smartphone;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartphoneRepository extends BaseTypeRepository<Smartphone> {
}
