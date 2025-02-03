package com.example.equipmentregister.dto.models;

import com.example.equipmentregister.dto.BaseModelDto;
import com.example.equipmentregister.models.VacuumModel;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель пылесоса")
public class VacuumModelDto extends BaseModelDto {
    private double dustContainerVolume;
    private int modesCount;
    private Long typeID;

    public VacuumModelDto() {
    }

    public VacuumModelDto(BaseModelDto baseModelDto) {
        super(baseModelDto);
    }

    public VacuumModelDto(VacuumModel model) {
        super(model.getName(), model.getSerialNumber(), model.getColor(), model.getLength(), model.getWidth(),
                model.getThickness(), model.getPrice(), model.isAvailability());
        this.dustContainerVolume = model.getDustContainerVolume();
        this.modesCount = model.getModesCount();
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
