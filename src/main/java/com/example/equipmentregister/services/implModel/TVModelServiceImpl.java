package com.example.equipmentregister.services.implModel;

import com.example.equipmentregister.dao.models.TVModelRepository;
import com.example.equipmentregister.dto.TVModelDto;
import com.example.equipmentregister.models.TVModel;
import com.example.equipmentregister.models.types.TV;
import com.example.equipmentregister.services.IModelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        if (models.isEmpty()) {
            return null;
        }

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

    @Transactional
    @Override
    public void addModel(TVModelDto tvModelDto) {
        tvModelRepository.save(new TVModel(tvModelDto.getName(),
                tvModelDto.getSerialNumber(),
                tvModelDto.getColor(),
                tvModelDto.getLength(),
                tvModelDto.getWidth(),
                tvModelDto.getThickness(),
                tvModelDto.getPrice(),
                tvModelDto.isAvailability(),
                tvModelDto.getCategory(),
                tvModelDto.getTechnology(),
                new TV(tvModelDto.getTypeID())));
    }
}
