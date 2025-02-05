package com.example.equipmentregister.models.types;

import com.example.equipmentregister.models.BaseTypeEntity;
import com.example.equipmentregister.models.Registry;
import com.example.equipmentregister.models.models.TVModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tv")
public class TV extends BaseTypeEntity {
    @ManyToOne
    @JoinColumn(name = "registry_id")
    @JsonIgnore
    private Registry registry;
    @OneToMany(mappedBy = "tv")
    @Where(clause = "availability = true")
    private List<TVModel> models;

    public TV() {
    }

    public TV(String manufactureCountry, String manufacturer, boolean possibilityOrderingOnline,
              boolean paymentByInstalments, Registry registry) {
        super(manufactureCountry, manufacturer, possibilityOrderingOnline, paymentByInstalments);
        this.registry = registry;
    }

    public TV(Long id) {
        super(id);
    }

    public List<TVModel> getModels() {
        return models;
    }

    public void setModels(List<TVModel> models) {
        this.models = models;
    }

    public Registry getRegistry() {
        return registry;
    }

    public void setRegistry(Registry registry) {
        this.registry = registry;
    }
}
