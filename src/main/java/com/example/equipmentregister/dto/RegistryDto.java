package com.example.equipmentregister.dto;

import com.example.equipmentregister.models.Registry;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Schema(description = "Реестр")
public class RegistryDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 64)
    @Schema(description = "Наименование вида техники", example = "Холодильник")
    private String name;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private List<Object> positions;

    public RegistryDto() {
    }

    public RegistryDto(String name) {
        this.name = name;
    }

    public RegistryDto(Registry registry) {
        this.id = registry.getId();
        this.name = registry.getName();
        this.positions = getPositionsList(registry);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getPositions() {
        return positions;
    }

    public void setPositions(List<Object> positions) {
        this.positions = positions;
    }

    private List<Object> getPositionsList(Registry registry) {
        List<Object> o = new ArrayList<>();

        if (registry.getComputerPositions().size() > 0) {
            o.add(registry.getComputerPositions());
        }

        if (registry.getComputerPositions().size() > 0) {
            o.add(registry.getComputerPositions());
        }

        if (registry.getFridgePositions().size() > 0) {
            o.add(registry.getFridgePositions());
        }

        if (registry.getSmartphonePositions().size() > 0) {
            o.add(registry.getSmartphonePositions());
        }

        if (registry.getTvPositions().size() > 0) {
            o.add(registry.getTvPositions());
        }

        if (registry.getVacuumPositions().size() > 0) {
            o.add(registry.getVacuumPositions());
        }

        return o;
    }
}
