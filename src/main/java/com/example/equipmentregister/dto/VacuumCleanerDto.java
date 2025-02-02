package com.example.equipmentregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель пылесоса")
public class VacuumCleanerDto extends BaseModelDto {
    private double dustContainerVolume;
    private int modesCount;
    private Long typeID;

    public VacuumCleanerDto() {
    }

    public VacuumCleanerDto(BaseModelDto baseModelDto) {
        super(baseModelDto);
    }

    public Long getTypeID() {
        return typeID;
    }

    public void setTypeID(Long typeID) {
        this.typeID = typeID;
    }

    public double getDustContainerVolume() {
        return dustContainerVolume;
    }

    public void setDustContainerVolume(double dustContainerVolume) {
        this.dustContainerVolume = dustContainerVolume;
    }

    public int getModesCount() {
        return modesCount;
    }

    public void setModesCount(int modesCount) {
        this.modesCount = modesCount;
    }
}
