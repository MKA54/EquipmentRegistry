package com.example.equipmentregister.dto.models;

import com.example.equipmentregister.dto.BaseModelDto;
import com.example.equipmentregister.models.models.TVModel;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Schema(description = "Модель телевизора")
public class TVModelDto extends BaseModelDto {
    @Size(min = 1, max = 64)
    @Schema(description = "Категория", example = "Цифровой")
    private String category;
    @Size(min = 1, max = 64)
    @Schema(description = "Технология", example = "LED")
    private String technology;
    @Schema(description = "Вид телевизора", example = "1")
    @Min(1)
    private Long typeID;

    public TVModelDto() {
    }

    public TVModelDto(TVModel model) {
        super(model.getId(), model.getName(), model.getSerialNumber(), model.getColor(), model.getLength(), model.getWidth(),
                model.getThickness(), model.getPrice(), model.isAvailability());
        this.category = model.getCategory();
        this.technology = model.getTechnology();
        typeID = model.getTv().getId();
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

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }
}
