package com.example.equipmentregister.services.modelImpl;

import com.example.equipmentregister.dao.models.FridgeModelRepository;
import com.example.equipmentregister.dto.models.FridgeModelDto;
import com.example.equipmentregister.models.FridgeModel;
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

    @Override
    public List<FridgeModelDto> getAll() {
        List<FridgeModel> models = fridgeModelRepository.findAll();

        return models
                .stream()
                .map(FridgeModelDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<FridgeModelDto> getAllTVModelsByNameCaseInsensitive(String name) {
        List<FridgeModel> models = fridgeModelRepository.findByNameLikeIgnoreCase(name);

        return models
                .stream()
                .map(FridgeModelDto::new)
                .collect(Collectors.toList());
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
}
