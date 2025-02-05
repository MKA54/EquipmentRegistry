package com.example.equipmentregister.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseModelRepository<T> extends JpaRepository<T, Long> {
    List<T> findByNameLikeIgnoreCase(String name);

    List<T> findBySerialNumberLikeIgnoreCase(String serialNumber);

    List<T> findByColorLikeIgnoreCase(String color);

    List<T> findByLength(double length);

    List<T> findByWidth(double width);

    List<T> findByThickness(double thickness);

    List<T> findByPrice(double price);

    List<T> findByAvailability(boolean availability);
}
