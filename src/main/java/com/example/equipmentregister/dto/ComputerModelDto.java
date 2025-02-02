package com.example.equipmentregister.dto;

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
