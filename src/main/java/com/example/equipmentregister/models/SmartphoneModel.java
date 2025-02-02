package com.example.equipmentregister.models;

import com.example.equipmentregister.models.types.Smartphone;

import javax.persistence.*;

@Entity
@Table
public class SmartphoneModel extends BaseModelEntity {
    @Column
    private int memory;
    @Column
    private int camerasCount;

    @ManyToOne
    @JoinColumn(name = "smartphone_id")
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
