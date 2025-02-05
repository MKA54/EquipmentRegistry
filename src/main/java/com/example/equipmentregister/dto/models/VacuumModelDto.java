package com.example.equipmentregister.dto.models;

import com.example.equipmentregister.dto.BaseModelDto;
import com.example.equipmentregister.models.models.VacuumModel;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Min;

@Schema(description = "Модель пылесоса")
public class VacuumModelDto extends BaseModelDto {
    @Schema(description = "Объём пылесборника", example = "1.4")
    private double dustContainerVolume;
    @Schema(description = "Количество режимов", example = "2")
    private int modesCount;
    @Schema(description = "Вид пылесоса", example = "1")
    @Min(1)
    private Long typeID;

    public VacuumModelDto() {
    }

    public VacuumModelDto(VacuumModel model) {
        super(model.getId(), model.getName(), model.getSerialNumber(), model.getColor(), model.getLength(), model.getWidth(),
                model.getThickness(), model.getPrice(), model.isAvailability());
        this.dustContainerVolume = model.getDustContainerVolume();
        this.modesCount = model.getModesCount();
        typeID = model.getVacuum().getId();
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
