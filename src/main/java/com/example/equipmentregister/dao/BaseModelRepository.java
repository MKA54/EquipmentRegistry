package com.example.equipmentregister.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseModelRepository<T> extends JpaRepository<T, Long> {
    List<T> findByNameLikeIgnoreCase(String name);
}
