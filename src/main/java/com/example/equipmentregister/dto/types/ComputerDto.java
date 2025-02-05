package com.example.equipmentregister.dto.types;

import com.example.equipmentregister.dto.BaseTypeDto;
import com.example.equipmentregister.dto.models.ComputerModelDto;
import com.example.equipmentregister.models.models.ComputerModel;
import com.example.equipmentregister.models.types.Computer;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.stream.Collectors;

@Schema(description = "Вид компьютера")
public class ComputerDto extends BaseTypeDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private List<ComputerModelDto> modelDtoList;

    public ComputerDto() {
    }

    public ComputerDto(Computer computer) {
        super(computer.getId(), computer.getManufactureCountry(), computer.getManufacturer(),
                computer.isPossibilityOrderingOnline(), computer.isPaymentByInstalments(), computer.getRegistry().getId());
        modelDtoList = convertModelToDto(computer.getModels());
    }

    public List<ComputerModelDto> getModelDtoList() {
        return modelDtoList;
    }

    public void setModelDtoList(List<ComputerModelDto> modelDtoList) {
        this.modelDtoList = modelDtoList;
    }

    private List<ComputerModelDto> convertModelToDto (List<ComputerModel> models){
        return models
                .stream()
                .map(ComputerModelDto::new)
                .collect(Collectors.toList());
    }
}
