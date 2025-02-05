package com.example.equipmentregister.models.models;

import com.example.equipmentregister.models.BaseModelEntity;
import com.example.equipmentregister.models.types.Computer;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table
public class ComputerModel extends BaseModelEntity {
    @Column
    @Size(min = 1, max = 64)
    private String category;
    @Column(name = "processor_type")
    @Size(min = 1, max = 64)
    private String processorType;

    @ManyToOne
    @JoinColumn(name = "computer_id")
    @JsonIgnore
    private Computer computer;

    public ComputerModel() {
    }

    public ComputerModel(String name, String serialNumber, String color, double length, double width,
                         double thickness, double price, boolean availability, String category, String processorType, Computer computer) {
        super(name, serialNumber, color, length, width, thickness, price, availability);
        this.category = category;
        this.processorType = processorType;
        this.computer = computer;
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

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
