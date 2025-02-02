package com.example.equipmentregister.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseTypeRepository <T> extends JpaRepository<T, Long> {
}
