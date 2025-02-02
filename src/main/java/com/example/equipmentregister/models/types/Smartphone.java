package com.example.equipmentregister.models.types;

import com.example.equipmentregister.models.SmartphoneModel;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table
public class Smartphone extends BaseTypeEntity {
    @OneToMany(mappedBy = "smartphone")
    @Where(clause = "availability = true")
    private Set<SmartphoneModel> models;

    public Smartphone() {
    }

    public Smartphone(Long id) {
       super(id);
    }

    public Set<SmartphoneModel> getModels() {
        return models;
    }

    public void setModels(Set<SmartphoneModel> models) {
        this.models = models;
    }
}
