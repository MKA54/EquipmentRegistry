package com.example.equipmentregister.models.types;

import com.example.equipmentregister.models.ComputerModel;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table
public class Computer extends BaseTypeEntity {
    @OneToMany(mappedBy = "computer")
    @Where(clause = "availability = true")
    private Set<ComputerModel> models;

    public Computer() {
    }

    public Computer(Long id) {
        super(id);
    }

    public Set<ComputerModel> getModels() {
        return models;
    }

    public void setModels(Set<ComputerModel> models) {
        this.models = models;
    }
}
