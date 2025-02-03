package com.example.equipmentregister.dto.models;

import com.example.equipmentregister.dto.BaseModelDto;
import com.example.equipmentregister.models.SmartphoneModel;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель смартфона")
public class SmartphoneModelDto extends BaseModelDto {
    private int memory;
    private int camerasCount;
    private Long typeID;

    public SmartphoneModelDto() {
    }

    public SmartphoneModelDto(BaseModelDto baseModelDto) {
        super(baseModelDto);
    }

    public SmartphoneModelDto(SmartphoneModel model) {
        super(model.getName(), model.getSerialNumber(), model.getColor(), model.getLength(), model.getWidth(),
                model.getThickness(), model.getPrice(), model.isAvailability());
        this.memory = model.getMemory();
        this.camerasCount = model.getCamerasCount();
    }

    public Long getTypeID() {
        return typeID;
    }

    public void setTypeID(Long typeID) {
        this.typeID = typeID;
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
