package com.example.equipmentregister.models.models;

import com.example.equipmentregister.models.BaseModelEntity;
import com.example.equipmentregister.models.types.Fridge;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table
public class FridgeModel extends BaseModelEntity {
    @Column(name = "doors_count")
    private int doorsCount;
    @Column(name = "compressor_type")
    @Size(min = 1, max = 64)
    private String compressorType;

    @ManyToOne
    @JoinColumn(name = "fridge_id")
    @JsonIgnore
    private Fridge fridge;

    public FridgeModel() {
    }

    public FridgeModel(String name, String serialNumber, String color, double length, double width,
                       double thickness, double price, boolean availability, int doorsCount, String compressorType, Fridge fridge) {
        super(name, serialNumber, color, length, width, thickness, price, availability);
        this.doorsCount = doorsCount;
        this.compressorType = compressorType;
        this.fridge = fridge;
    }

    public int getDoorsCount() {
        return doorsCount;
    }

    public void setDoorsCount(int doorsCount) {
        this.doorsCount = doorsCount;
    }

    public String getCompressorType() {
        return compressorType;
    }

    public void setCompressorType(String compressorType) {
        this.compressorType = compressorType;
    }

    public Fridge getFridge() {
        return fridge;
    }

    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }
}
