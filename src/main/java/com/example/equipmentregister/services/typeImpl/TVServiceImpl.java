package com.example.equipmentregister.services.typeImpl;

import com.example.equipmentregister.dao.types.TVRepository;
import com.example.equipmentregister.dto.types.TVDto;
import com.example.equipmentregister.models.Registry;
import com.example.equipmentregister.models.types.TV;
import com.example.equipmentregister.services.ITypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TVServiceImpl implements ITypeService<TVDto> {
    private final TVRepository tvRepository;

    public TVServiceImpl(TVRepository tvRepository) {
        this.tvRepository = tvRepository;
    }

    @Override
    public List<TVDto> getAllAvailable() {
        List<TV> repo = tvRepository.findAll();
        return typeToDto(repo);
    }

    @Override
    public void add(TVDto model) {
        tvRepository.save(new TV(
                model.getManufactureCountry(),
                model.getManufacturer(),
                model.isPossibilityOrderingOnline(),
                model.isPaymentByInstalments(),
                new Registry(model.getRegistryID())));
    }

    private List<TVDto> typeToDto(List<TV> repo) {
        return repo
                .stream()
                .map(TVDto::new)
                .collect(Collectors.toList());
    }
}
