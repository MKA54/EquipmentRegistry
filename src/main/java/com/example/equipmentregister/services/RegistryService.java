package com.example.equipmentregister.services;

import com.example.equipmentregister.dao.RegistryRepository;
import com.example.equipmentregister.dto.RegistryDto;
import com.example.equipmentregister.models.Registry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class RegistryService {
    private final RegistryRepository repository;

    public RegistryService(RegistryRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void add(RegistryDto registryDto) {
        repository.save(new Registry(registryDto.getName()));
    }

    public List<RegistryDto> getAllAvailable() {
        List<Registry> registries = repository.findAll();
        return convertModelToDto(registries);
    }

    public List<RegistryDto> getAllAlphabetically() {
        List<Registry> registries = repository.getAllByOrderByName();
        return convertModelToDto(registries);
    }

    public List<RegistryDto> getAllByOrderByPrice() {
        List<Registry> registries = repository.findAll();
        return convertModelToDto(registries);
    }

    private List<RegistryDto> convertModelToDto(List<Registry> registries) {
        return registries
                .stream()
                .map(RegistryDto::new)
                .collect(Collectors.toList());
    }
}
