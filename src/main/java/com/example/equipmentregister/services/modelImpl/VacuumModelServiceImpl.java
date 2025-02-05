package com.example.equipmentregister.services.modelImpl;

import com.example.equipmentregister.dao.models.VacuumModelRepository;
import com.example.equipmentregister.dto.models.VacuumModelDto;
import com.example.equipmentregister.models.models.VacuumModel;
import com.example.equipmentregister.models.types.Vacuum;
import com.example.equipmentregister.services.IModelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacuumModelServiceImpl implements IModelService<VacuumModelDto> {
    private final VacuumModelRepository vacuumModelRepository;

    public VacuumModelServiceImpl(VacuumModelRepository vacuumModelRepository) {
        this.vacuumModelRepository = vacuumModelRepository;
    }

    public List<VacuumModelDto> getAllByDustContainerVolume(double dustContainerVolume) {
        List<VacuumModel> models = vacuumModelRepository.findByDustContainerVolume(dustContainerVolume);
        return convertModelToDto(models);
    }

    public List<VacuumModelDto> getAllByModesCount(int modesCount) {
        List<VacuumModel> models = vacuumModelRepository.findByModesCount(modesCount);
        return convertModelToDto(models);
    }

    @Override
    public List<VacuumModelDto> getAll() {
        List<VacuumModel> models = vacuumModelRepository.findAll();
        return convertModelToDto(models);
    }

    @Override
    public List<VacuumModelDto> getAllByNameCaseInsensitive(String name) {
        List<VacuumModel> models = vacuumModelRepository.findByNameLikeIgnoreCase(name);
        return convertModelToDto(models);
    }

    @Override
    public List<VacuumModelDto> getAllBySerialNumberLikeIgnoreCase(String serialNumber) {
        List<VacuumModel> models = vacuumModelRepository.findByNameLikeIgnoreCase(serialNumber);
        return convertModelToDto(models);
    }

    @Override
    public List<VacuumModelDto> getAllByColorLikeIgnoreCase(String color) {
        List<VacuumModel> models = vacuumModelRepository.findByColorLikeIgnoreCase(color);
        return convertModelToDto(models);
    }

    @Override
    public List<VacuumModelDto> getAllByLength(double length) {
        List<VacuumModel> models = vacuumModelRepository.findByLength(length);
        return convertModelToDto(models);
    }

    @Override
    public List<VacuumModelDto> getAllByWidth(double width) {
        List<VacuumModel> models = vacuumModelRepository.findByWidth(width);
        return convertModelToDto(models);
    }

    @Override
    public List<VacuumModelDto> getAllByThickness(double thickness) {
        List<VacuumModel> models = vacuumModelRepository.findByThickness(thickness);
        return convertModelToDto(models);
    }

    @Override
    public List<VacuumModelDto> getAllByPrice(double price) {
        List<VacuumModel> models = vacuumModelRepository.findByPrice(price);
        return convertModelToDto(models);
    }

    @Override
    public List<VacuumModelDto> getAllByAvailability(boolean availability) {
        List<VacuumModel> models = vacuumModelRepository.findByAvailability(availability);
        return convertModelToDto(models);
    }

    @Override
    public void add(VacuumModelDto model) {
        vacuumModelRepository.save(new VacuumModel(model.getName(),
                model.getSerialNumber(),
                model.getColor(),
                model.getLength(),
                model.getWidth(),
                model.getThickness(),
                model.getPrice(),
                model.isAvailability(),
                model.getDustContainerVolume(),
                model.getModesCount(),
                new Vacuum(model.getTypeID())));
    }

    private List<VacuumModelDto> convertModelToDto(List<VacuumModel> models) {
        return models
                .stream()
                .map(VacuumModelDto::new)
                .collect(Collectors.toList());
    }
}
