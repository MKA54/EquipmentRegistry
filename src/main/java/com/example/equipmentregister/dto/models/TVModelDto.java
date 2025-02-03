package com.example.equipmentregister.dto.models;

import com.example.equipmentregister.dto.BaseModelDto;
import com.example.equipmentregister.models.TVModel;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель телевизора")
public class TVModelDto extends BaseModelDto {
    private String category;
    private String technology;
    private Long typeID;

    public TVModelDto() {
    }

    public TVModelDto(BaseModelDto baseModelDto) {
        super(baseModelDto);
    }

    public TVModelDto(String name, String serialNumber, String color, double length, double width, double thickness,
                      double price, boolean availability, String category, String technology, Long typeID) {
        super(name, serialNumber, color, length, width, thickness, price, availability);
        this.category = category;
        this.technology = technology;
        this.typeID = typeID;
    }

    public TVModelDto(TVModel model) {
        super(model.getName(), model.getSerialNumber(), model.getColor(), model.getLength(), model.getWidth(),
                model.getThickness(), model.getPrice(), model.isAvailability());
        this.category = model.getCategory();
        this.technology = model.getTechnology();
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
