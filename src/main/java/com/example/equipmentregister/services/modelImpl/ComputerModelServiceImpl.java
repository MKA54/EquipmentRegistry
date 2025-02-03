package com.example.equipmentregister.services.modelImpl;

import com.example.equipmentregister.dao.models.ComputerModelRepository;
import com.example.equipmentregister.dto.models.ComputerModelDto;
import com.example.equipmentregister.models.ComputerModel;
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

    @Override
    public List<ComputerModelDto> getAll() {
        List<ComputerModel> models = computerModelRepository.findAll();

        return models
                .stream()
                .map(ComputerModelDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ComputerModelDto> getAllTVModelsByNameCaseInsensitive(String name) {
        List<ComputerModel> models = computerModelRepository.findByNameLikeIgnoreCase(name);

        return models
                .stream()
                .map(ComputerModelDto::new)
                .collect(Collectors.toList());
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
}
