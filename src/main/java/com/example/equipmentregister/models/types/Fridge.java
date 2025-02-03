package com.example.equipmentregister.models.types;

import com.example.equipmentregister.models.FridgeModel;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class Fridge extends BaseTypeEntity {
    @OneToMany(mappedBy = "fridge")
    @Where(clause = "availability = true")
    private List<FridgeModel> models;

    public Fridge() {
    }

    public Fridge(String name, String manufactureCountry, String manufacturer, boolean possibilityOrderingOnline,
                  boolean paymentByInstalments) {
        super(name, manufactureCountry, manufacturer, possibilityOrderingOnline, paymentByInstalments);
    }

    public Fridge(Long id, String name, String manufactureCountry, String manufacturer, boolean possibilityOrderingOnline,
                  boolean paymentByInstalments, List<FridgeModel> models) {
        super(id, name, manufactureCountry, manufacturer, possibilityOrderingOnline, paymentByInstalments);
        this.models = models;
    }

    public Fridge(Long id) {
        super(id);
    }

    public List<FridgeModel> getModels() {
        return models;
    }

    public void setModels(List<FridgeModel> models) {
        this.models = models;
    }
}
