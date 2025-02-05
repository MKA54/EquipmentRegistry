package com.example.equipmentregister.models.types;

import com.example.equipmentregister.models.BaseTypeEntity;
import com.example.equipmentregister.models.Registry;
import com.example.equipmentregister.models.models.VacuumModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Vacuum extends BaseTypeEntity {
    @ManyToOne
    @JoinColumn(name = "registry_id")
    @JsonIgnore
    private Registry registry;
    @OneToMany(mappedBy = "vacuum")
    @Where(clause = "availability = true")
    private List<VacuumModel> models;

    public Vacuum() {
    }

    public Vacuum(String manufactureCountry, String manufacturer, boolean possibilityOrderingOnline,
                  boolean paymentByInstalments, Registry registry) {
        super(manufactureCountry, manufacturer, possibilityOrderingOnline, paymentByInstalments);
        this.registry = registry;
    }

    public Vacuum(Long id) {
        super(id);
    }

    public List<VacuumModel> getModels() {
        return models;
    }

    public void setModels(List<VacuumModel> models) {
        this.models = models;
    }

    public Registry getRegistry() {
        return registry;
    }

    public void setRegistry(Registry registry) {
        this.registry = registry;
    }
}
