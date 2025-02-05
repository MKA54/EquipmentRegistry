package com.example.equipmentregister.dao;

import com.example.equipmentregister.models.Registry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistryRepository extends JpaRepository<Registry, Long> {
    List<Registry> getAllByOrderByName();
}
