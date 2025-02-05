package com.example.equipmentregister.services.typeImpl;

import com.example.equipmentregister.dao.types.ComputerRepository;
import com.example.equipmentregister.dto.types.ComputerDto;
import com.example.equipmentregister.models.Registry;
import com.example.equipmentregister.models.types.Computer;
import com.example.equipmentregister.services.ITypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComputerServiceImpl implements ITypeService<ComputerDto> {
    private final ComputerRepository computerRepository;

    public ComputerServiceImpl(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    @Override
    public List<ComputerDto> getAllAvailable() {
        List<Computer> repo = computerRepository.findAll();
        return typeToDto(repo);
    }

    @Override
    public void add(ComputerDto model) {
        computerRepository.save(new Computer(
                model.getManufactureCountry(),
                model.getManufacturer(),
                model.isPossibilityOrderingOnline(),
                model.isPaymentByInstalments(),
                new Registry(model.getRegistryID())));
    }

    private List<ComputerDto> typeToDto(List<Computer> repo) {
        return repo
                .stream()
                .map(ComputerDto::new)
                .collect(Collectors.toList());
    }
}
