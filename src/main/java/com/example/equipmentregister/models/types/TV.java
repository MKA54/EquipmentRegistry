package com.example.equipmentregister.models.types;

import com.example.equipmentregister.models.TVModel;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "tv")
public class TV extends BaseTypeEntity {
    @OneToMany(mappedBy = "tv")
    @Where(clause = "availability = true")
    private List<TVModel> models;

    public TV() {
    }

    public TV(String name, String manufactureCountry, String manufacturer, boolean possibilityOrderingOnline,
              boolean paymentByInstalments) {
        super(name, manufactureCountry, manufacturer, possibilityOrderingOnline, paymentByInstalments);
    }

    public TV(Long id, String name, String manufactureCountry, String manufacturer, boolean possibilityOrderingOnline,
              boolean paymentByInstalments, List<TVModel> models) {
        super(id, name, manufactureCountry, manufacturer, possibilityOrderingOnline, paymentByInstalments);
        this.models = models;
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
}
