package com.example.equipmentregister.dto.models;

import com.example.equipmentregister.dto.BaseModelDto;
import com.example.equipmentregister.models.models.SmartphoneModel;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;

@Schema(description = "Модель смартфона")
public class SmartphoneModelDto extends BaseModelDto {
    @Schema(description = "Память", example = "128")
    private int memory;
    @Schema(description = "Количество камер", example = "3")
    private int camerasCount;
    @Schema(description = "Вид смартфона", example = "1")
    @Min(1)
    private Long typeID;

    public SmartphoneModelDto() {
    }

    public SmartphoneModelDto(SmartphoneModel model) {
        super(model.getId(), model.getName(), model.getSerialNumber(), model.getColor(), model.getLength(), model.getWidth(),
                model.getThickness(), model.getPrice(), model.isAvailability());
        this.memory = model.getMemory();
        this.camerasCount = model.getCamerasCount();
        typeID = model.getSmartphone().getId();
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
