package com.example.equipmentregister.services;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IModelService<T> {
    List<T> getAll();

    List<T> getAllTVModelsByNameCaseInsensitive(String name);

    @Transactional
    void add(T model);
}
