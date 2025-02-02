package com.example.equipmentregister.controllers;

import com.example.equipmentregister.dto.TVModelDto;
import com.example.equipmentregister.services.IModelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment/rpc/api/v1/tv/model")
@Tag(name = "Модели телевизоров")
public class TVModelController {
    private final IModelService<TVModelDto> modelService;

    public TVModelController(IModelService<TVModelDto> modelService) {
        this.modelService = modelService;
    }

    @Operation(summary = "Добавить модель")
    @PostMapping("add")
    public ResponseEntity<?> add(TVModelDto tvModelDto) {
        modelService.addModel(tvModelDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Получить все модели")
    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        List<TVModelDto> tvModels = modelService.getAll();
        return new ResponseEntity<>(tvModels, HttpStatus.OK);
    }

    @Operation(summary = "Найти по наименованию, без учета регистра")
    @GetMapping("getByNameCaseInsensitive/{name}")
    public ResponseEntity<?> getByNameCaseInsensitive(@PathVariable("name") String name) {
        List<TVModelDto> tvModels = modelService.getAllTVModelsByNameCaseInsensitive(name);
        return new ResponseEntity<>(tvModels, HttpStatus.OK);
    }
}
