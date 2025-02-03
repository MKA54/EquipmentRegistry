package com.example.equipmentregister.controllers.models;

import com.example.equipmentregister.dto.models.VacuumModelDto;
import com.example.equipmentregister.services.IModelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment/rpc/api/v1/vacuum/model")
@Tag(name = "Модели пылесосов")
public class VacuumModelController {
    private final IModelService<VacuumModelDto> modelService;

    public VacuumModelController(IModelService<VacuumModelDto> modelService) {
        this.modelService = modelService;
    }

    @Operation(summary = "Добавить модель")
    @PostMapping("add")
    public ResponseEntity<?> add(VacuumModelDto model) {
        modelService.add(model);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Получить все модели")
    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        List<VacuumModelDto> models = modelService.getAll();
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Operation(summary = "Найти по наименованию, без учета регистра")
    @GetMapping("getByNameCaseInsensitive/{name}")
    public ResponseEntity<?> getByNameCaseInsensitive(@PathVariable("name") String name) {
        List<VacuumModelDto> models = modelService.getAllTVModelsByNameCaseInsensitive(name);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }
}
