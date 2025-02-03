package com.example.equipmentregister.dto.models;

import com.example.equipmentregister.dto.BaseModelDto;
import com.example.equipmentregister.models.FridgeModel;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель холодильника")
public class FridgeModelDto extends BaseModelDto {
    private int doorsCount;
    private String compressorType;

    private Long typeID;

    public FridgeModelDto() {
    }

    public FridgeModelDto(BaseModelDto baseModelDto) {
        super(baseModelDto);
    }

    public FridgeModelDto(FridgeModel model) {
        super(model.getName(), model.getSerialNumber(), model.getColor(), model.getLength(), model.getWidth(),
                model.getThickness(), model.getPrice(), model.isAvailability());
        this.doorsCount = model.getDoorsCount();
        this.compressorType = model.getCompressorType();
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
