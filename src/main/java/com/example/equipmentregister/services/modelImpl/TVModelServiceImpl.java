package com.example.equipmentregister.services.modelImpl;

import com.example.equipmentregister.dao.models.TVModelRepository;
import com.example.equipmentregister.dto.models.TVModelDto;
import com.example.equipmentregister.models.models.TVModel;
import com.example.equipmentregister.models.types.TV;
import com.example.equipmentregister.services.IModelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TVModelServiceImpl implements IModelService<TVModelDto> {
    private final TVModelRepository tvModelRepository;

    public TVModelServiceImpl(TVModelRepository tvModelRepository) {
        this.tvModelRepository = tvModelRepository;
    }

    public List<TVModelDto> getAllByCategoryLikeIgnoreCase(String category) {
        List<TVModel> models = tvModelRepository.findByCategoryLikeIgnoreCase(category);
        return convertModelToDto(models);
    }

    public List<TVModelDto> getAllByTechnologyLikeIgnoreCase(String technology) {
        List<TVModel> models = tvModelRepository.findByTechnologyLikeIgnoreCase(technology);
        return convertModelToDto(models);
    }

    @Override
    public List<TVModelDto> getAll() {
        List<TVModel> models = tvModelRepository.findAll();
        return convertModelToDto(models);
    }

    @Override
    public List<TVModelDto> getAllByNameCaseInsensitive(String name) {
        List<TVModel> models = tvModelRepository.findByNameLikeIgnoreCase(name);
        return convertModelToDto(models);
    }

    @Override
    public List<TVModelDto> getAllBySerialNumberLikeIgnoreCase(String serialNumber) {
        List<TVModel> models = tvModelRepository.findBySerialNumberLikeIgnoreCase(serialNumber);
        return convertModelToDto(models);
    }

    @Override
    public List<TVModelDto> getAllByColorLikeIgnoreCase(String color) {
        List<TVModel> models = tvModelRepository.findByColorLikeIgnoreCase(color);
        return convertModelToDto(models);
    }

    @Override
    public List<TVModelDto> getAllByLength(double length) {
        List<TVModel> models = tvModelRepository.findByLength(length);
        return convertModelToDto(models);
    }

    @Override
    public List<TVModelDto> getAllByWidth(double width) {
        List<TVModel> models = tvModelRepository.findByWidth(width);
        return convertModelToDto(models);
    }

    @Override
    public List<TVModelDto> getAllByThickness(double thickness) {
        List<TVModel> models = tvModelRepository.findByThickness(thickness);
        return convertModelToDto(models);
    }

    @Override
    public List<TVModelDto> getAllByPrice(double price) {
        List<TVModel> models = tvModelRepository.findByPrice(price);
        return convertModelToDto(models);
    }

    @Override
    public List<TVModelDto> getAllByAvailability(boolean availability) {
        List<TVModel> models = tvModelRepository.findByAvailability(availability);
        return convertModelToDto(models);
    }

    @Override
    public void add(TVModelDto model) {
        tvModelRepository.save(new TVModel(model.getName(),
                model.getSerialNumber(),
                model.getColor(),
                model.getLength(),
                model.getWidth(),
                model.getThickness(),
                model.getPrice(),
                model.isAvailability(),
                model.getCategory(),
                model.getTechnology(),
                new TV(model.getTypeID())));
    }

    private List<TVModelDto> convertModelToDto(List<TVModel> models) {
        return models
                .stream()
                .map(TVModelDto::new)
                .collect(Collectors.toList());
    }
}
