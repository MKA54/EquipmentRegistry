package com.example.equipmentregister.dao.types;

import com.example.equipmentregister.dao.BaseTypeRepository;
import com.example.equipmentregister.models.types.TV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TVRepository extends BaseTypeRepository<TV> {
}
