package com.example.equipmentregister.dto;

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
