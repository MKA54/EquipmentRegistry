package com.example.equipmentregister.services.modelImpl;

import com.example.equipmentregister.dao.models.VacuumModelRepository;
import com.example.equipmentregister.dto.models.VacuumModelDto;
import com.example.equipmentregister.models.VacuumModel;
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

    @Override
    public List<VacuumModelDto> getAll() {
        List<VacuumModel> models = vacuumModelRepository.findAll();

        return models
                .stream()
                .map(VacuumModelDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<VacuumModelDto> getAllTVModelsByNameCaseInsensitive(String name) {
        List<VacuumModel> models = vacuumModelRepository.findByNameLikeIgnoreCase(name);

        return models
                .stream()
                .map(VacuumModelDto::new)
                .collect(Collectors.toList());
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
}
