package com.example.equipmentregister.dao.models;

import com.example.equipmentregister.models.FridgeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FridgeModelRepository extends JpaRepository<FridgeModel, Long> {
}
