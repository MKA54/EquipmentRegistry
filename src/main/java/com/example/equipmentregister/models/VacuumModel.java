package com.example.equipmentregister.models;

import com.example.equipmentregister.models.types.Vacuum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table
public class VacuumModel extends BaseModelEntity {
    @Column
    private double dustContainerVolume;
    @Column
    private int modesCount;

    @ManyToOne
    @JoinColumn(name = "vacuum_id")
    @JsonIgnore
    private Vacuum vacuum;

    public VacuumModel() {
    }

    public VacuumModel(String name, String serialNumber, String color, double length, double width,
                       double thickness, double price, boolean availability, double dustContainerVolume, int modesCount, Vacuum vacuum) {
        super(name, serialNumber, color, length, width, thickness, price, availability);
        this.dustContainerVolume = dustContainerVolume;
        this.modesCount = modesCount;
        this.vacuum = vacuum;
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

    public Vacuum getVacuum() {
        return vacuum;
    }

    public void setVacuum(Vacuum vacuum) {
        this.vacuum = vacuum;
    }
}
