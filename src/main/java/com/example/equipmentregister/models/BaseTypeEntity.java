package com.example.equipmentregister.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@MappedSuperclass
public class BaseTypeEntity implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "manufacture_country")
    @Size(min = 1, max = 64)
    private String manufactureCountry;
    @Column
    @Size(min = 1, max = 64)
    private String manufacturer;
    @Column(name = "possibility_ordering_online")
    private boolean possibilityOrderingOnline;
    @Column(name = "payment_by_instalments")
    private boolean paymentByInstalments;

    public BaseTypeEntity() {
    }

    public BaseTypeEntity(Long id) {
        this.id = id;
    }

    public BaseTypeEntity(String manufactureCountry, String manufacturer,
                          boolean possibilityOrderingOnline, boolean paymentByInstalments) {
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
