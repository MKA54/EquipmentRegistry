package com.example.equipmentregister.dto.models;

import com.example.equipmentregister.dto.BaseModelDto;
import com.example.equipmentregister.models.ComputerModel;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель компьютера")
public class ComputerModelDto extends BaseModelDto {
    private String category;
    private String processorType;

    private Long typeID;

    public ComputerModelDto() {
    }

    public ComputerModelDto(BaseModelDto baseModelDto) {
        super(baseModelDto);
    }

    public ComputerModelDto(ComputerModel model) {
        super(model.getName(), model.getSerialNumber(), model.getColor(), model.getLength(), model.getWidth(),
                model.getThickness(), model.getPrice(), model.isAvailability());
        this.category = model.getCategory();
        this.processorType = model.getProcessorType();
    }

    public Long getTypeID() {
        return typeID;
    }

    public void setTypeID(Long typeID) {
        this.typeID = typeID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }
}
