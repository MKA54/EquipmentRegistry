package com.example.equipmentregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.*;

public class BaseModelDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 64)
    @Schema(description = "Наименование", example = "Galaxy")
    private String name;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 64)
    @Schema(description = "Серийный номер", example = "S25")
    private String serialNumber;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 64)
    @Schema(description = "Цвет", example = "Белый")
    private String color;
    @PositiveOrZero
    @Schema(description = "Длина", example = "15")
    private double length;
    @PositiveOrZero
    @Schema(description = "Ширина", example = "54")
    private double width;
    @PositiveOrZero
    @Schema(description = "Глубина", example = "4")
    private double thickness;
    @PositiveOrZero
    @Schema(description = "Цена", example = "66.5")
    private double price;
    @Schema(description = "Наличие товара", example = "true")
    private boolean availability;

    public BaseModelDto() {
    }

    public BaseModelDto(Long id, String name, String serialNumber,
                        String color, double length, double width, double thickness, double price, boolean availability) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
