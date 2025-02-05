package com.example.equipmentregister.services;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface IModelService<T> {
    @Transactional
    void add(T model);

    List<T> getAll();

    List<T> getAllByNameCaseInsensitive(String name);

    List<T> getAllBySerialNumberLikeIgnoreCase(String serialNumber);

    List<T> getAllByColorLikeIgnoreCase(String color);

    List<T> getAllByLength(double length);

    List<T> getAllByWidth(double width);

    List<T> getAllByThickness(double thickness);

    List<T> getAllByPrice(double price);

    List<T> getAllByAvailability(boolean availability);
}
