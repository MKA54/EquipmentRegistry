package com.example.equipmentregister.services;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface ITypeService<T> {
    List<T> getAllAvailable();

    @Transactional
    void add(T model);
}
