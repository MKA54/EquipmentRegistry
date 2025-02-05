package com.example.equipmentregister.models.models;

import com.example.equipmentregister.models.BaseModelEntity;
import com.example.equipmentregister.models.types.TV;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table
public class TVModel extends BaseModelEntity {
    @Column
    @Size(min = 1, max = 64)
    private String category;
    @Column
    @Size(min = 1, max = 64)
    private String technology;

    @ManyToOne
    @JoinColumn(name = "tv_id")
    @JsonIgnore
    private TV tv;

    public TVModel() {
    }

    public TVModel(String name, String serialNumber, String color, double length, double width, double thickness,
                   double price, boolean availability, String category, String technology, TV tv) {
        super(name, serialNumber, color, length, width, thickness, price, availability);
        this.category = category;
        this.technology = technology;
        this.tv = tv;
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

    public TV getTv() {
        return tv;
    }

    public void setTv(TV tv) {
        this.tv = tv;
    }
}
