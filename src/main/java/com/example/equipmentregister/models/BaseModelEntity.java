package com.example.equipmentregister.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@MappedSuperclass
public class BaseModelEntity implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @Size(min = 1, max = 64)
    private String name;
    @Column(name = "serial_number")
    @Size(min = 1, max = 64)
    @NotNull
    @NotBlank
    private String serialNumber;
    @Column
    @Size(min = 1, max = 64)
    @NotNull
    @NotBlank
    private String color;
    @Column
    private double length;
    @Column
    private double width;
    @Column
    private double thickness;
    @Column
    private double price;
    @Column
    private boolean availability;

    public BaseModelEntity() {
    }

    public BaseModelEntity(Long id) {
        this.id = id;
    }

    public BaseModelEntity(String name, String serialNumber, String color,
                           double length, double width, double thickness, double price, boolean availability) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.color = color;
        this.length = length;
        this.width = width;
        this.thickness = thickness;
        this.price = price;
        this.availability = availability;
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
