package com.example.equipmentregister.services;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ITypeService<T> {
    List<T> getAllAvailable();

    @Transactional
    void add(T model);
}
