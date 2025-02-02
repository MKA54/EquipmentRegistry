package com.example.equipmentregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель смартфона")
public class SmartphoneModelDto extends BaseModelDto {
    private int memory;
    private int camerasCount;
    private Long typeID;

    public SmartphoneModelDto() {
    }

    public Long getTypeID() {
        return typeID;
    }

    public void setTypeID(Long typeID) {
        this.typeID = typeID;
    }

    public SmartphoneModelDto(BaseModelDto baseModelDto) {
        super(baseModelDto);
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getCamerasCount() {
        return camerasCount;
    }

    public void setCamerasCount(int camerasCount) {
        this.camerasCount = camerasCount;
    }
}
