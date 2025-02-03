package com.example.equipmentregister.services.modelImpl;

import com.example.equipmentregister.dao.models.SmartphoneModelRepository;
import com.example.equipmentregister.dto.models.SmartphoneModelDto;
import com.example.equipmentregister.models.SmartphoneModel;
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

    @Override
    public List<SmartphoneModelDto> getAll() {
        List<SmartphoneModel> models = smartphoneModelRepository.findAll();

        return models
                .stream()
                .map(SmartphoneModelDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<SmartphoneModelDto> getAllTVModelsByNameCaseInsensitive(String name) {
        List<SmartphoneModel> models = smartphoneModelRepository.findByNameLikeIgnoreCase(name);

        return models
                .stream()
                .map(SmartphoneModelDto::new)
                .collect(Collectors.toList());
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
}
