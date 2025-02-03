package com.example.equipmentregister.services.typeImpl;

import com.example.equipmentregister.dao.types.VacuumRepository;
import com.example.equipmentregister.dto.types.VacuumDto;
import com.example.equipmentregister.models.types.Vacuum;
import com.example.equipmentregister.services.ITypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacuumServiceImpl implements ITypeService<VacuumDto> {
    private final VacuumRepository vacuumRepository;

    public VacuumServiceImpl(VacuumRepository vacuumRepository) {
        this.vacuumRepository = vacuumRepository;
    }

    @Override
    public List<VacuumDto> getAllAvailable() {
        List<Vacuum> repo = vacuumRepository.findAll();
        return repo
                .stream()
                .map(VacuumDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public void add(VacuumDto model) {
        vacuumRepository.save(new Vacuum(model.getName(),
                model.getManufactureCountry(),
                model.getManufacturer(),
                model.isPossibilityOrderingOnline(),
                model.isPaymentByInstalments()));
    }
}
