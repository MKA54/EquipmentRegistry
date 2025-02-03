package com.example.equipmentregister.models.types;

import com.example.equipmentregister.models.SmartphoneModel;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class Smartphone extends BaseTypeEntity {
    @OneToMany(mappedBy = "smartphone")
    @Where(clause = "availability = true")
    private List<SmartphoneModel> models;

    public Smartphone() {
    }

    public Smartphone(String name, String manufactureCountry, String manufacturer, boolean possibilityOrderingOnline,
                      boolean paymentByInstalments) {
        super(name, manufactureCountry, manufacturer, possibilityOrderingOnline, paymentByInstalments);
    }

    public Smartphone(Long id, String name, String manufactureCountry, String manufacturer, boolean possibilityOrderingOnline,
                      boolean paymentByInstalments, List<SmartphoneModel> models) {
        super(id, name, manufactureCountry, manufacturer, possibilityOrderingOnline, paymentByInstalments);
        this.models = models;
    }

    public Smartphone(Long id) {
        super(id);
    }

    public List<SmartphoneModel> getModels() {
        return models;
    }

    public void setModels(List<SmartphoneModel> models) {
        this.models = models;
    }
}
