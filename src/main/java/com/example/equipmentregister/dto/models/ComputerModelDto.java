package com.example.equipmentregister.dto.models;

import com.example.equipmentregister.dto.BaseModelDto;
import com.example.equipmentregister.models.models.ComputerModel;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Schema(description = "Модель компьютера")
public class ComputerModelDto extends BaseModelDto {
    @Size(min = 1, max = 64)
    @Schema(description = "Категория", example = "ПК")
    private String category;
    @Size(min = 1, max = 64)
    @Schema(description = "Тип процесса", example = "i5")
    private String processorType;

    @Schema(description = "Вид компьютера", example = "1")
    @Min(1)
    private Long typeID;

    public ComputerModelDto() {
    }

    public ComputerModelDto(ComputerModel model) {
        super(model.getId(), model.getName(), model.getSerialNumber(), model.getColor(), model.getLength(), model.getWidth(),
                model.getThickness(), model.getPrice(), model.isAvailability());
        this.category = model.getCategory();
        this.processorType = model.getProcessorType();
        typeID = model.getComputer().getId();
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
