package com.example.equipmentregister.models.types;

import com.example.equipmentregister.models.FridgeModel;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table
public class Fridge extends BaseTypeEntity {
    @OneToMany(mappedBy = "fridge")
    @Where(clause = "availability = true")
    private Set<FridgeModel> models;

    public Fridge() {
    }

    public Fridge(Long id) {
        super(id);
    }

    public Set<FridgeModel> getModels() {
        return models;
    }

    public void setModels(Set<FridgeModel> models) {
        this.models = models;
    }
}
