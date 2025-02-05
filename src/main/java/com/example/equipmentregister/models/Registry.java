package com.example.equipmentregister.models;

import com.example.equipmentregister.models.types.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Registry implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(min = 1, max = 64)
    @NotNull
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "registry")
    private List<Computer> computerPositions;
    @OneToMany(mappedBy = "registry")
    private List<Fridge> fridgePositions;
    @OneToMany(mappedBy = "registry")
    private List<Smartphone> smartphonePositions;
    @OneToMany(mappedBy = "registry")
    private List<TV> tvPositions;
    @OneToMany(mappedBy = "registry")
    private List<Vacuum> vacuumPositions;

    public Registry() {
    }

    public Registry(Long id) {
        this.id = id;
    }

    public Registry(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Registry(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Computer> getComputerPositions() {
        return computerPositions;
    }

    public void setComputerPositions(List<Computer> computerPositions) {
        this.computerPositions = computerPositions;
    }

    public List<Fridge> getFridgePositions() {
        return fridgePositions;
    }

    public void setFridgePositions(List<Fridge> fridgePositions) {
        this.fridgePositions = fridgePositions;
    }

    public List<Smartphone> getSmartphonePositions() {
        return smartphonePositions;
    }

    public void setSmartphonePositions(List<Smartphone> smartphonePositions) {
        this.smartphonePositions = smartphonePositions;
    }

    public List<TV> getTvPositions() {
        return tvPositions;
    }

    public void setTvPositions(List<TV> tvPositions) {
        this.tvPositions = tvPositions;
    }

    public List<Vacuum> getVacuumPositions() {
        return vacuumPositions;
    }

    public void setVacuumPositions(List<Vacuum> vacuumPositions) {
        this.vacuumPositions = vacuumPositions;
    }
}
