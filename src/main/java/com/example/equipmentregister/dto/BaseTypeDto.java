package com.example.equipmentregister.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.*;

public class BaseTypeDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 64)
    @Schema(description = "Страна производства", example = "Белорусь")
    private String manufactureCountry;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 64)
    @Schema(description = "Завод", example = "Искра")
    private String manufacturer;

    @Schema(description = "Возможность заказа онлайн", example = "true")
    private boolean possibilityOrderingOnline;
    @Schema(description = "Возможность оформления рассрочки", example = "true")
    private boolean paymentByInstalments;

    @Schema(description = "Наименование в реестре", example = "1")
    @Min(1)
    private Long registryID;

    public BaseTypeDto() {
    }

    public BaseTypeDto(Long id, String manufactureCountry, String manufacturer,
                       boolean possibilityOrderingOnline, boolean paymentByInstalments, Long registryID) {
        this.id = id;
        this.manufactureCountry = manufactureCountry;
        this.manufacturer = manufacturer;
        this.possibilityOrderingOnline = possibilityOrderingOnline;
        this.paymentByInstalments = paymentByInstalments;
        this.registryID = registryID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getRegistryID() {
        return registryID;
    }

    public void setRegistryID(Long registryID) {
        this.registryID = registryID;
    }
}
