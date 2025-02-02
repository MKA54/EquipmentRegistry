package com.example.equipmentregister.models.types;

import com.example.equipmentregister.models.VacuumModel;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table
public class Vacuum extends BaseTypeEntity {
    @OneToMany(mappedBy = "vacuum")
    @Where(clause = "availability = true")
    private Set<VacuumModel> models;

    public Vacuum() {
    }

    public Vacuum(Long id) {
        super(id);
    }

    public Set<VacuumModel> getModels() {
        return models;
    }

    public void setModels(Set<VacuumModel> models) {
        this.models = models;
    }
}
