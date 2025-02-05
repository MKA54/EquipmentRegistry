package com.example.equipmentregister.dto.types;

import com.example.equipmentregister.dto.BaseTypeDto;
import com.example.equipmentregister.dto.models.FridgeModelDto;
import com.example.equipmentregister.models.models.FridgeModel;
import com.example.equipmentregister.models.types.Fridge;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.stream.Collectors;

@Schema(description = "Вид холодильника")
public class FridgeDto extends BaseTypeDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private List<FridgeModelDto> modelDtoList;

    public FridgeDto() {
    }

    public FridgeDto(Fridge fridge) {
        super(fridge.getId(), fridge.getManufactureCountry(), fridge.getManufacturer(),
                fridge.isPossibilityOrderingOnline(), fridge.isPaymentByInstalments(), fridge.getRegistry().getId());
        modelDtoList = convertModelToDto(fridge.getModels());
    }

    public List<FridgeModelDto> getModelDtoList() {
        return modelDtoList;
    }

    public void setModelDtoList(List<FridgeModelDto> modelDtoList) {
        this.modelDtoList = modelDtoList;
    }

    private List<FridgeModelDto> convertModelToDto(List<FridgeModel> models) {
        return models
                .stream()
                .map(FridgeModelDto::new)
                .collect(Collectors.toList());
    }
}
