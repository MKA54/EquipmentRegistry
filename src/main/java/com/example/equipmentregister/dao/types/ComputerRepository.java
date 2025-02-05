package com.example.equipmentregister.dao.types;

import com.example.equipmentregister.dao.BaseTypeRepository;
import com.example.equipmentregister.models.types.Computer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerRepository extends BaseTypeRepository<Computer> {
}
