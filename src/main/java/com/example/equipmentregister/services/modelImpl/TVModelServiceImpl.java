package com.example.equipmentregister.services.modelImpl;

import com.example.equipmentregister.dao.models.TVModelRepository;
import com.example.equipmentregister.dto.models.TVModelDto;
import com.example.equipmentregister.models.TVModel;
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

    @Override
    public List<TVModelDto> getAll() {
        List<TVModel> models = tvModelRepository.findAll();

        return models
                .stream()
                .map(TVModelDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<TVModelDto> getAllTVModelsByNameCaseInsensitive(String name) {
        List<TVModel> models = tvModelRepository.findByNameLikeIgnoreCase(name);

        return models
                .stream()
                .map(TVModelDto::new)
                .collect(Collectors.toList());
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
}
