package com.example.equipmentregister.dto;

import javax.validation.constraints.*;

public class BaseModelDto {
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 64)
    private String name;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 64)
    private String serialNumber;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 64)
    private String color;
    @PositiveOrZero
    private double length;
    @PositiveOrZero
    private double width;
    @PositiveOrZero
    private double thickness;
    @PositiveOrZero
    private double price;
    private boolean availability;

    public BaseModelDto() {
    }

    public BaseModelDto(BaseModelDto basic) {
        name = basic.name;
        serialNumber = basic.serialNumber;
        color = basic.color;
        length = basic.length;
        width = basic.width;
        thickness = basic.thickness;
        price = basic.price;
        availability = basic.availability;
    }

    public BaseModelDto(String name, String serialNumber, String color, double length, double width,
                        double thickness, double price, boolean availability) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.color = color;
        this.length = length;
        this.width = width;
        this.thickness = thickness;
        this.price = price;
        this.availability = availability;
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
