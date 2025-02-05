package com.example.equipmentregister.models.types;

import com.example.equipmentregister.models.BaseTypeEntity;
import com.example.equipmentregister.models.Registry;
import com.example.equipmentregister.models.models.SmartphoneModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Smartphone extends BaseTypeEntity {
    @ManyToOne
    @JoinColumn(name = "registry_id")
    @JsonIgnore
    private Registry registry;
    @OneToMany(mappedBy = "smartphone")
    @Where(clause = "availability = true")
    private List<SmartphoneModel> models;

    public Smartphone() {
    }

    public Smartphone(String manufactureCountry, String manufacturer, boolean possibilityOrderingOnline,
                      boolean paymentByInstalments, Registry registry) {
        super(manufactureCountry, manufacturer, possibilityOrderingOnline, paymentByInstalments);
        this.registry = registry;
    }


    public Smartphone(Long id) {
        super(id);
    }

    public List<SmartphoneModel> getModels() {
        return models;
    }

    public void setModels(List<SmartphoneModel> models) {
        this.models = models;
    }

    public Registry getRegistry() {
        return registry;
    }

    public void setRegistry(Registry registry) {
        this.registry = registry;
    }
}
