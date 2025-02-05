package com.example.equipmentregister.services.typeImpl;

import com.example.equipmentregister.dao.types.FridgeRepository;
import com.example.equipmentregister.dto.types.FridgeDto;
import com.example.equipmentregister.models.Registry;
import com.example.equipmentregister.models.types.Fridge;
import com.example.equipmentregister.services.ITypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FridgeServiceImpl implements ITypeService<FridgeDto> {
    private final FridgeRepository fridgeRepository;

    public FridgeServiceImpl(FridgeRepository fridgeRepository) {
        this.fridgeRepository = fridgeRepository;
    }

    @Override
    public List<FridgeDto> getAllAvailable() {
        List<Fridge> repo = fridgeRepository.findAll();
        return typeToDto(repo);
    }

    @Override
    public void add(FridgeDto model) {
        fridgeRepository.save(new Fridge(
                model.getManufactureCountry(),
                model.getManufacturer(),
                model.isPossibilityOrderingOnline(),
                model.isPaymentByInstalments(),
                new Registry(model.getRegistryID())));
    }

    private List<FridgeDto> typeToDto(List<Fridge> repo) {
        return repo
                .stream()
                .map(FridgeDto::new)
                .collect(Collectors.toList());
    }
}
