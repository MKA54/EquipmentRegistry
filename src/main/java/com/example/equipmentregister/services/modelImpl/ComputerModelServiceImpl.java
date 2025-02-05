package com.example.equipmentregister.services.modelImpl;

import com.example.equipmentregister.dao.models.ComputerModelRepository;
import com.example.equipmentregister.dto.models.ComputerModelDto;
import com.example.equipmentregister.models.models.ComputerModel;
import com.example.equipmentregister.models.types.Computer;
import com.example.equipmentregister.services.IModelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComputerModelServiceImpl implements IModelService<ComputerModelDto> {
    private final ComputerModelRepository computerModelRepository;

    public ComputerModelServiceImpl(ComputerModelRepository computerModelRepository) {
        this.computerModelRepository = computerModelRepository;
    }

    public List<ComputerModelDto> getAllByCategoryLikeIgnoreCase(String category) {
        List<ComputerModel> models = computerModelRepository.findByCategoryLikeIgnoreCase(category);
        return convertModelToDto(models);
    }

    public List<ComputerModelDto> getAllByProcessorTypeLikeIgnoreCase(String processorType) {
        List<ComputerModel> models = computerModelRepository.findByProcessorTypeLikeIgnoreCase(processorType);
        return convertModelToDto(models);
    }

    @Override
    public List<ComputerModelDto> getAll() {
        List<ComputerModel> models = computerModelRepository.findAll();
        return convertModelToDto(models);
    }

    @Override
    public List<ComputerModelDto> getAllByNameCaseInsensitive(String name) {
        List<ComputerModel> models = computerModelRepository.findByNameLikeIgnoreCase(name);
        return convertModelToDto(models);
    }

    @Override
    public List<ComputerModelDto> getAllBySerialNumberLikeIgnoreCase(String serialNumber) {
        List<ComputerModel> models = computerModelRepository.findBySerialNumberLikeIgnoreCase(serialNumber);
        return convertModelToDto(models);
    }

    @Override
    public List<ComputerModelDto> getAllByColorLikeIgnoreCase(String color) {
        List<ComputerModel> models = computerModelRepository.findByColorLikeIgnoreCase(color);
        return convertModelToDto(models);
    }

    @Override
    public List<ComputerModelDto> getAllByLength(double length) {
        List<ComputerModel> models = computerModelRepository.findByLength(length);
        return convertModelToDto(models);
    }

    @Override
    public List<ComputerModelDto> getAllByWidth(double width) {
        List<ComputerModel> models = computerModelRepository.findByWidth(width);
        return convertModelToDto(models);
    }

    @Override
    public List<ComputerModelDto> getAllByThickness(double thickness) {
        List<ComputerModel> models = computerModelRepository.findByThickness(thickness);
        return convertModelToDto(models);
    }

    @Override
    public List<ComputerModelDto> getAllByPrice(double price) {
        List<ComputerModel> models = computerModelRepository.findByPrice(price);
        return convertModelToDto(models);
    }

    @Override
    public List<ComputerModelDto> getAllByAvailability(boolean availability) {
        List<ComputerModel> models = computerModelRepository.findByAvailability(availability);
        return convertModelToDto(models);
    }

    @Override
    public void add(ComputerModelDto model) {
        computerModelRepository.save(new ComputerModel(model.getName(),
                model.getSerialNumber(),
                model.getColor(),
                model.getLength(),
                model.getWidth(),
                model.getThickness(),
                model.getPrice(),
                model.isAvailability(),
                model.getCategory(),
                model.getProcessorType(),
                new Computer(model.getTypeID())));
    }

    private List<ComputerModelDto> convertModelToDto(List<ComputerModel> models) {
        return models
                .stream()
                .map(ComputerModelDto::new)
                .collect(Collectors.toList());
    }
}
