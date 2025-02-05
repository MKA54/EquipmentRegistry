package com.example.equipmentregister.dto.models;

import com.example.equipmentregister.dto.BaseModelDto;
import com.example.equipmentregister.models.models.FridgeModel;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Schema(description = "Модель холодильника")
public class FridgeModelDto extends BaseModelDto {
    @Schema(description = "Количество дверей", example = "1")
    private int doorsCount;
    @Size(min = 1, max = 64)
    @Schema(description = "Тип компрессора", example = "Линейный")
    private String compressorType;

    @Schema(description = "Вид холодильника", example = "1")
    @Min(1)
    private Long typeID;

    public FridgeModelDto() {
    }

    public FridgeModelDto(FridgeModel model) {
        super(model.getId(), model.getName(), model.getSerialNumber(), model.getColor(), model.getLength(), model.getWidth(),
                model.getThickness(), model.getPrice(), model.isAvailability());
        this.doorsCount = model.getDoorsCount();
        this.compressorType = model.getCompressorType();
        typeID = model.getFridge().getId();
    }

    public Long getTypeID() {
        return typeID;
    }

    public void setTypeID(Long typeID) {
        this.typeID = typeID;
    }

    public int getDoorsCount() {
        return doorsCount;
    }

    public void setDoorsCount(int doorsCount) {
        this.doorsCount = doorsCount;
    }

    public String getCompressorType() {
        return compressorType;
    }

    public void setCompressorType(String compressorType) {
        this.compressorType = compressorType;
    }
}
