package com.example.equipmentregister.dto.types;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BaseTypeDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 64)
    private String name;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 64)
    private String manufactureCountry;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 64)
    private String manufacturer;
    private boolean possibilityOrderingOnline;
    private boolean paymentByInstalments;

    public BaseTypeDto() {
    }

    public BaseTypeDto(Long id, String name, String manufactureCountry,
                       String manufacturer, boolean possibilityOrderingOnline, boolean paymentByInstalments) {
        this.id = id;
        this.name = name;
        this.manufactureCountry = manufactureCountry;
        this.manufacturer = manufacturer;
        this.possibilityOrderingOnline = possibilityOrderingOnline;
        this.paymentByInstalments = paymentByInstalments;
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

    public String getManufactureCountry() {
        return manufactureCountry;
    }

    public void setManufactureCountry(String manufactureCountry) {
        this.manufactureCountry = manufactureCountry;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isPossibilityOrderingOnline() {
        return possibilityOrderingOnline;
    }

    public void setPossibilityOrderingOnline(boolean possibilityOrderingOnline) {
        this.possibilityOrderingOnline = possibilityOrderingOnline;
    }

    public boolean isPaymentByInstalments() {
        return paymentByInstalments;
    }

    public void setPaymentByInstalments(boolean paymentByInstalments) {
        this.paymentByInstalments = paymentByInstalments;
    }
}
