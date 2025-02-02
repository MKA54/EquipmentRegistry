package com.example.equipmentregister.dto;

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

    public TVModelDto(TVModel tvModel) {
        super(tvModel.getName(), tvModel.getSerialNumber(), tvModel.getColor(), tvModel.getLength(), tvModel.getWidth(),
                tvModel.getThickness(), tvModel.getPrice(), tvModel.isAvailability());
        this.category = tvModel.getCategory();
        this.technology = tvModel.getTechnology();
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
