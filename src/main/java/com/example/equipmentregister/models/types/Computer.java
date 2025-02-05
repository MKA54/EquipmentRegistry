package com.example.equipmentregister.models.types;

import com.example.equipmentregister.models.BaseTypeEntity;
import com.example.equipmentregister.models.Registry;
import com.example.equipmentregister.models.models.ComputerModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Computer extends BaseTypeEntity {
    @ManyToOne
    @JoinColumn(name = "registry_id")
    @JsonIgnore
    private Registry registry;
    @OneToMany(mappedBy = "computer")
    @Where(clause = "availability = true")
    private List<ComputerModel> models;

    public Computer() {
    }

    public Computer(String manufactureCountry, String manufacturer, boolean possibilityOrderingOnline,
                    boolean paymentByInstalments, Registry registry) {
        super(manufactureCountry, manufacturer, possibilityOrderingOnline, paymentByInstalments);
        this.registry = registry;
    }


    public Computer(Long id) {
        super(id);
    }

    public List<ComputerModel> getModels() {
        return models;
    }

    public void setModels(List<ComputerModel> models) {
        this.models = models;
    }

    public Registry getRegistry() {
        return registry;
    }

    public void setRegistry(Registry registry) {
        this.registry = registry;
    }
}
