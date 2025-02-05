package com.example.equipmentregister.services.typeImpl;

import com.example.equipmentregister.dao.types.SmartphoneRepository;
import com.example.equipmentregister.dto.types.SmartphoneDto;
import com.example.equipmentregister.models.Registry;
import com.example.equipmentregister.models.types.Smartphone;
import com.example.equipmentregister.services.ITypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SmartphoneServiceImpl implements ITypeService<SmartphoneDto> {
    private final SmartphoneRepository smartphoneRepository;

    public SmartphoneServiceImpl(SmartphoneRepository smartphoneRepository) {
        this.smartphoneRepository = smartphoneRepository;
    }

    @Override
    public List<SmartphoneDto> getAllAvailable() {
        List<Smartphone> repo = smartphoneRepository.findAll();
        return typeToDto(repo);
    }

    @Override
    public void add(SmartphoneDto model) {
        smartphoneRepository.save(new Smartphone(
                model.getManufactureCountry(),
                model.getManufacturer(),
                model.isPossibilityOrderingOnline(),
                model.isPaymentByInstalments(),
                new Registry(model.getRegistryID())));
    }

    private List<SmartphoneDto> typeToDto(List<Smartphone> repo) {
        return repo
                .stream()
                .map(SmartphoneDto::new)
                .collect(Collectors.toList());
    }
}
