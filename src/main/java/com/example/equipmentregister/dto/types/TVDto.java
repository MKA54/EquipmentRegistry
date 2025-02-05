package com.example.equipmentregister.dto.types;

import com.example.equipmentregister.dto.BaseTypeDto;
import com.example.equipmentregister.dto.models.TVModelDto;
import com.example.equipmentregister.models.models.TVModel;
import com.example.equipmentregister.models.types.TV;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.stream.Collectors;

@Schema(description = "Вид телевизора")
public class TVDto extends BaseTypeDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private List<TVModelDto> modelDtoList;

    public TVDto() {
    }

    public TVDto(TV tv) {
        super(tv.getId(), tv.getManufactureCountry(), tv.getManufacturer(),
                tv.isPossibilityOrderingOnline(), tv.isPaymentByInstalments(), tv.getRegistry().getId());
        modelDtoList = convertModelToDto(tv.getModels());
    }

    public List<TVModelDto> getModelDtoList() {
        return modelDtoList;
    }

    public void setModelDtoList(List<TVModelDto> modelDtoList) {
        this.modelDtoList = modelDtoList;
    }

    private List<TVModelDto> convertModelToDto(List<TVModel> models) {
        return models
                .stream()
                .map(TVModelDto::new)
                .collect(Collectors.toList());
    }
}
