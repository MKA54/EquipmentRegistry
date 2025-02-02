package com.example.equipmentregister.models.types;

import com.example.equipmentregister.models.TVModel;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "tv")
public class TV extends BaseTypeEntity {
    @OneToMany(mappedBy = "tv")
    @Where(clause = "availability = true")
    private Set<TVModel> models;

    public TV() {
    }

    public TV(String name, String manufactureCountry, String manufacturer, boolean possibilityOrderingOnline,
              boolean paymentByInstalments) {
        super(name, manufactureCountry, manufacturer, possibilityOrderingOnline, paymentByInstalments);
    }

    public TV(Long id) {
        super(id);
    }

    public Set<TVModel> getModels() {
        return models;
    }

    public void setModels(Set<TVModel> models) {
        this.models = models;
    }
}
