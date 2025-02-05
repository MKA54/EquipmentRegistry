package com.example.equipmentregister.services.modelImpl;

import com.example.equipmentregister.dao.models.FridgeModelRepository;
import com.example.equipmentregister.dto.models.FridgeModelDto;
import com.example.equipmentregister.models.models.FridgeModel;
import com.example.equipmentregister.models.types.Fridge;
import com.example.equipmentregister.services.IModelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FridgeModelServiceImpl implements IModelService<FridgeModelDto> {
    private final FridgeModelRepository fridgeModelRepository;

    public FridgeModelServiceImpl(FridgeModelRepository fridgeModelRepository) {
        this.fridgeModelRepository = fridgeModelRepository;
    }

    public List<FridgeModelDto> getAllByDoorsCount(int doorsCount) {
        List<FridgeModel> models = fridgeModelRepository.findByDoorsCount(doorsCount);
        return convertModelToDto(models);
    }

    public List<FridgeModelDto> getAllByCompressorTypeLikeIgnoreCase(String compressorType) {
        List<FridgeModel> models = fridgeModelRepository.findByCompressorTypeLikeIgnoreCase(compressorType);
        return convertModelToDto(models);
    }

    @Override
    public List<FridgeModelDto> getAll() {
        List<FridgeModel> models = fridgeModelRepository.findAll();
        return convertModelToDto(models);
    }

    @Override
    public List<FridgeModelDto> getAllByNameCaseInsensitive(String name) {
        List<FridgeModel> models = fridgeModelRepository.findByNameLikeIgnoreCase(name);
        return convertModelToDto(models);
    }

    @Override
    public List<FridgeModelDto> getAllBySerialNumberLikeIgnoreCase(String serialNumber) {
        List<FridgeModel> models = fridgeModelRepository.findBySerialNumberLikeIgnoreCase(serialNumber);
        return convertModelToDto(models);
    }

    @Override
    public List<FridgeModelDto> getAllByColorLikeIgnoreCase(String color) {
        List<FridgeModel> models = fridgeModelRepository.findByColorLikeIgnoreCase(color);
        return convertModelToDto(models);
    }

    @Override
    public List<FridgeModelDto> getAllByLength(double length) {
        List<FridgeModel> models = fridgeModelRepository.findByLength(length);
        return convertModelToDto(models);
    }

    @Override
    public List<FridgeModelDto> getAllByWidth(double width) {
        List<FridgeModel> models = fridgeModelRepository.findByWidth(width);
        return convertModelToDto(models);
    }

    @Override
    public List<FridgeModelDto> getAllByThickness(double thickness) {
        List<FridgeModel> models = fridgeModelRepository.findByThickness(thickness);
        return convertModelToDto(models);
    }

    @Override
    public List<FridgeModelDto> getAllByPrice(double price) {
        List<FridgeModel> models = fridgeModelRepository.findByPrice(price);
        return convertModelToDto(models);
    }

    @Override
    public List<FridgeModelDto> getAllByAvailability(boolean availability) {
        List<FridgeModel> models = fridgeModelRepository.findByAvailability(availability);
        return convertModelToDto(models);
    }

    @Override
    public void add(FridgeModelDto model) {
        fridgeModelRepository.save(new FridgeModel(model.getName(),
                model.getSerialNumber(),
                model.getColor(),
                model.getLength(),
                model.getWidth(),
                model.getThickness(),
                model.getPrice(),
                model.isAvailability(),
                model.getDoorsCount(),
                model.getCompressorType(),
                new Fridge(model.getTypeID())));
    }

    private List<FridgeModelDto> convertModelToDto(List<FridgeModel> models) {
        return models
                .stream()
                .map(FridgeModelDto::new)
                .collect(Collectors.toList());
    }
}
