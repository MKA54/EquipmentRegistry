package com.example.equipmentregister.dto.types;

import com.example.equipmentregister.dto.BaseTypeDto;
import com.example.equipmentregister.dto.models.SmartphoneModelDto;
import com.example.equipmentregister.models.models.SmartphoneModel;
import com.example.equipmentregister.models.types.Smartphone;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.stream.Collectors;

@Schema(description = "Вид смартфона")
public class SmartphoneDto extends BaseTypeDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private List<SmartphoneModelDto> modelDtoList;

    public SmartphoneDto() {
    }

    public SmartphoneDto(Smartphone smartphone) {
        super(smartphone.getId(), smartphone.getManufactureCountry(), smartphone.getManufacturer(),
                smartphone.isPossibilityOrderingOnline(), smartphone.isPaymentByInstalments(), smartphone.getRegistry().getId());
        modelDtoList = convertModelToDto(smartphone.getModels());
    }

    public List<SmartphoneModelDto> getModelDtoList() {
        return modelDtoList;
    }

    public void setModelDtoList(List<SmartphoneModelDto> modelDtoList) {
        this.modelDtoList = modelDtoList;
    }

    private List<SmartphoneModelDto> convertModelToDto(List<SmartphoneModel> models) {
        return models
                .stream()
                .map(SmartphoneModelDto::new)
                .collect(Collectors.toList());
    }
}
