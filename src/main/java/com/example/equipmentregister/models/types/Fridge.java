package com.example.equipmentregister.models.types;

import com.example.equipmentregister.models.BaseTypeEntity;
import com.example.equipmentregister.models.Registry;
import com.example.equipmentregister.models.models.FridgeModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Fridge extends BaseTypeEntity {
    @ManyToOne
    @JoinColumn(name = "registry_id")
    @JsonIgnore
    private Registry registry;
    @OneToMany(mappedBy = "fridge")
    @Where(clause = "availability = true")
    private List<FridgeModel> models;

    public Fridge() {
    }

    public Fridge(String manufactureCountry, String manufacturer, boolean possibilityOrderingOnline,
                  boolean paymentByInstalments, Registry registry) {
        super(manufactureCountry, manufacturer, possibilityOrderingOnline, paymentByInstalments);
        this.registry = registry;
    }


    public Fridge(Long id) {
        super(id);
    }

    public List<FridgeModel> getModels() {
        return models;
    }

    public void setModels(List<FridgeModel> models) {
        this.models = models;
    }

    public Registry getRegistry() {
        return registry;
    }

    public void setRegistry(Registry registry) {
        this.registry = registry;
    }
}
