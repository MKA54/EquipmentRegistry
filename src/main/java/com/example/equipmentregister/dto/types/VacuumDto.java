package com.example.equipmentregister.dto.types;

import com.example.equipmentregister.dto.BaseTypeDto;
import com.example.equipmentregister.dto.models.VacuumModelDto;
import com.example.equipmentregister.models.VacuumModel;
import com.example.equipmentregister.models.types.Vacuum;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.stream.Collectors;

@Schema(description = "Вид пылесоса")
public class VacuumDto extends BaseTypeDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private List<VacuumModelDto> modelDtoList;

    public VacuumDto() {
    }

    public VacuumDto(Vacuum vacuum) {
        super(vacuum.getId(), vacuum.getName(), vacuum.getManufactureCountry(), vacuum.getManufacturer(),
                vacuum.isPossibilityOrderingOnline(), vacuum.isPaymentByInstalments());
        modelDtoList = convertModelToDto(vacuum.getModels());
    }

    public List<VacuumModelDto> getModelDtoList() {
        return modelDtoList;
    }

    public void setModelDtoList(List<VacuumModelDto> modelDtoList) {
        this.modelDtoList = modelDtoList;
    }

    private List<VacuumModelDto> convertModelToDto(List<VacuumModel> models) {
        return models
                .stream()
                .map(VacuumModelDto::new)
                .collect(Collectors.toList());
    }
}
