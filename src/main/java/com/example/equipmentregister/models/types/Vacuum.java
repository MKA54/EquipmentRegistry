package com.example.equipmentregister.models.types;

import com.example.equipmentregister.models.VacuumModel;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class Vacuum extends BaseTypeEntity {
    @OneToMany(mappedBy = "vacuum")
    @Where(clause = "availability = true")
    private List<VacuumModel> models;

    public Vacuum() {
    }

    public Vacuum(String name, String manufactureCountry, String manufacturer, boolean possibilityOrderingOnline,
                  boolean paymentByInstalments) {
        super(name, manufactureCountry, manufacturer, possibilityOrderingOnline, paymentByInstalments);
    }

    public Vacuum(Long id, String name, String manufactureCountry, String manufacturer, boolean possibilityOrderingOnline,
                  boolean paymentByInstalments, List<VacuumModel> models) {
        super(id, name, manufactureCountry, manufacturer, possibilityOrderingOnline, paymentByInstalments);
        this.models = models;
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
}
