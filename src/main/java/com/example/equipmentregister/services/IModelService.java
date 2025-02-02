package com.example.equipmentregister.services;

import com.example.equipmentregister.dto.TVModelDto;

import java.util.List;

public interface IModelService<T> {
    List<TVModelDto> getAll();
    List<TVModelDto> getAllTVModelsByNameCaseInsensitive(String name);
    void addModel(TVModelDto model);
}
