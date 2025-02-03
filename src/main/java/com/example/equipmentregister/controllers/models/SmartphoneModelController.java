package com.example.equipmentregister.controllers.models;

import com.example.equipmentregister.dto.models.SmartphoneModelDto;
import com.example.equipmentregister.services.IModelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment/rpc/api/v1/smartphone/model")
@Tag(name = "Модели мартфонов")
public class SmartphoneModelController {
    private final IModelService<SmartphoneModelDto> modelService;

    public SmartphoneModelController(IModelService<SmartphoneModelDto> modelService) {
        this.modelService = modelService;
    }

    @Operation(summary = "Добавить модель")
    @PostMapping("add")
    public ResponseEntity<?> add(SmartphoneModelDto model) {
        modelService.add(model);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Получить все модели")
    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        List<SmartphoneModelDto> models = modelService.getAll();
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Operation(summary = "Найти по наименованию, без учета регистра")
    @GetMapping("getByNameCaseInsensitive/{name}")
    public ResponseEntity<?> getByNameCaseInsensitive(@PathVariable("name") String name) {
        List<SmartphoneModelDto> models = modelService.getAllTVModelsByNameCaseInsensitive(name);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }
}
