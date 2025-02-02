package com.example.equipmentregister.dao.models;

import com.example.equipmentregister.models.SmartphoneModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SmartphoneModelRepository extends JpaRepository<SmartphoneModel, Long> {
}
