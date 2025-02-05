package com.example.equipmentregister.models.models;

import com.example.equipmentregister.models.BaseModelEntity;
import com.example.equipmentregister.models.types.Smartphone;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
public class SmartphoneModel extends BaseModelEntity {
    @Column
    private int memory;

    @Column(name = "cameras_count")
    private int camerasCount;

    @ManyToOne
    @JoinColumn(name = "smartphone_id")
    @JsonIgnore
    private Smartphone smartphone;

    public SmartphoneModel() {
    }

    public SmartphoneModel(String name, String serialNumber, String color, double length, double width,
                           double thickness, double price, boolean availability, int memory, int camerasCount, Smartphone smartphone) {
        super(name, serialNumber, color, length, width, thickness, price, availability);
        this.memory = memory;
        this.camerasCount = camerasCount;
        this.smartphone = smartphone;
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

    public Smartphone getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(Smartphone smartphone) {
        this.smartphone = smartphone;
    }
}
