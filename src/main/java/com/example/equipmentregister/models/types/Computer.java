package com.example.equipmentregister.models.types;

import com.example.equipmentregister.models.ComputerModel;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class Computer extends BaseTypeEntity {
    @OneToMany(mappedBy = "computer")
    @Where(clause = "availability = true")
    private List<ComputerModel> models;

    public Computer() {
    }

    public Computer(String name, String manufactureCountry, String manufacturer, boolean possibilityOrderingOnline,
                    boolean paymentByInstalments) {
        super(name, manufactureCountry, manufacturer, possibilityOrderingOnline, paymentByInstalments);
    }

    public Computer(Long id, String name, String manufactureCountry, String manufacturer, boolean possibilityOrderingOnline,
                    boolean paymentByInstalments, List<ComputerModel> models) {
        super(id, name, manufactureCountry, manufacturer, possibilityOrderingOnline, paymentByInstalments);
        this.models = models;
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
}
