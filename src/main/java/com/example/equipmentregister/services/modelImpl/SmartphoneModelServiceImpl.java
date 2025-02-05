package com.example.equipmentregister.services.modelImpl;

import com.example.equipmentregister.dao.models.SmartphoneModelRepository;
import com.example.equipmentregister.dto.models.SmartphoneModelDto;
import com.example.equipmentregister.models.models.SmartphoneModel;
import com.example.equipmentregister.models.types.Smartphone;
import com.example.equipmentregister.services.IModelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SmartphoneModelServiceImpl implements IModelService<SmartphoneModelDto> {
    private final SmartphoneModelRepository smartphoneModelRepository;

    public SmartphoneModelServiceImpl(SmartphoneModelRepository smartphoneModelRepository) {
        this.smartphoneModelRepository = smartphoneModelRepository;
    }

    public List<SmartphoneModelDto> getAllByMemory(int memory) {
        List<SmartphoneModel> models = smartphoneModelRepository.findByMemory(memory);
        return convertModelToDto(models);
    }

    public List<SmartphoneModelDto> getAllByByCamerasCount(int camerasCount) {
        List<SmartphoneModel> models = smartphoneModelRepository.findByCamerasCount(camerasCount);
        return convertModelToDto(models);
    }

    @Override
    public List<SmartphoneModelDto> getAll() {
        List<SmartphoneModel> models = smartphoneModelRepository.findAll();
        return convertModelToDto(models);
    }

    @Override
    public List<SmartphoneModelDto> getAllByNameCaseInsensitive(String name) {
        List<SmartphoneModel> models = smartphoneModelRepository.findByNameLikeIgnoreCase(name);
        return convertModelToDto(models);
    }

    @Override
    public List<SmartphoneModelDto> getAllBySerialNumberLikeIgnoreCase(String serialNumber) {
        List<SmartphoneModel> models = smartphoneModelRepository.findBySerialNumberLikeIgnoreCase(serialNumber);
        return convertModelToDto(models);
    }

    @Override
    public List<SmartphoneModelDto> getAllByColorLikeIgnoreCase(String color) {
        List<SmartphoneModel> models = smartphoneModelRepository.findByColorLikeIgnoreCase(color);
        return convertModelToDto(models);
    }

    @Override
    public List<SmartphoneModelDto> getAllByLength(double length) {
        List<SmartphoneModel> models = smartphoneModelRepository.findByLength(length);
        return convertModelToDto(models);
    }

    @Override
    public List<SmartphoneModelDto> getAllByWidth(double width) {
        List<SmartphoneModel> models = smartphoneModelRepository.findByWidth(width);
        return convertModelToDto(models);
    }

    @Override
    public List<SmartphoneModelDto> getAllByThickness(double thickness) {
        List<SmartphoneModel> models = smartphoneModelRepository.findByThickness(thickness);
        return convertModelToDto(models);
    }

    @Override
    public List<SmartphoneModelDto> getAllByPrice(double price) {
        List<SmartphoneModel> models = smartphoneModelRepository.findByPrice(price);
        return convertModelToDto(models);
    }

    @Override
    public List<SmartphoneModelDto> getAllByAvailability(boolean availability) {
        List<SmartphoneModel> models = smartphoneModelRepository.findByAvailability(availability);
        return convertModelToDto(models);
    }

    @Override
    public void add(SmartphoneModelDto model) {
        smartphoneModelRepository.save(new SmartphoneModel(model.getName(),
                model.getSerialNumber(),
                model.getColor(),
                model.getLength(),
                model.getWidth(),
                model.getThickness(),
                model.getPrice(),
                model.isAvailability(),
                model.getMemory(),
                model.getCamerasCount(),
                new Smartphone(model.getTypeID())));
    }

    private List<SmartphoneModelDto> convertModelToDto(List<SmartphoneModel> models) {
        return models
                .stream()
                .map(SmartphoneModelDto::new)
                .collect(Collectors.toList());
    }
}
