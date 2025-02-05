package com.example.equipmentregister.controllers.models;

import com.example.equipmentregister.controllers.BaseModelController;
import com.example.equipmentregister.dto.models.TVModelDto;
import com.example.equipmentregister.services.modelImpl.TVModelServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/equipment/rpc/api/v1/tv/model")
@Tag(name = "Модели телевизоров", description = "Возможные операции с моделями: добавление, получение по параметру и получить всё")
public class TVModelController implements BaseModelController {
    private final TVModelServiceImpl modelService;

    public TVModelController(TVModelServiceImpl modelService) {
        this.modelService = modelService;
    }

    @Operation(summary = "Добавить модель")
    @PostMapping("add")
    public ResponseEntity<?> add(@Valid TVModelDto model) {
        modelService.add(model);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Получить все модели по категории")
    @GetMapping(value = "getAllByCategoryLikeIgnoreCase/{category}")
    @ApiResponse(responseCode = "400", description = "Неверный запрос — категория не может быть пустой или null")
    ResponseEntity<?> getAllByCategoryLikeIgnoreCase(@PathVariable("category")
                                                     @Parameter(description = "Категория")
                                                     @NotNull @NotEmpty @NotBlank String category) {
        List<TVModelDto> models = modelService.getAllByCategoryLikeIgnoreCase(category);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Operation(summary = "Получить все модели по технологии")
    @GetMapping(value = "getAllByTechnologyLikeIgnoreCase/{technology}")
    @ApiResponse(responseCode = "400", description = "Неверный запрос — технология не может быть пустой или null")
    ResponseEntity<?> getAllByTechnologyLikeIgnoreCase(@PathVariable("technology")
                                                       @Parameter(description = "Технология")
                                                       @NotNull @NotEmpty @NotBlank String technology) {
        List<TVModelDto> models = modelService.getAllByTechnologyLikeIgnoreCase(technology);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<TVModelDto> models = modelService.getAll();
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByNameLikeIgnoreCase(String name) {
        List<TVModelDto> models = modelService.getAllByNameCaseInsensitive(name);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllBySerialNumberLikeIgnoreCase(String serialNumber) {
        List<TVModelDto> models = modelService.getAllBySerialNumberLikeIgnoreCase(serialNumber);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByColorLikeIgnoreCase(String color) {
        List<TVModelDto> models = modelService.getAllByColorLikeIgnoreCase(color);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByLength(double length) {
        List<TVModelDto> models = modelService.getAllByLength(length);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByWidth(double width) {
        List<TVModelDto> models = modelService.getAllByWidth(width);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByThickness(double thickness) {
        List<TVModelDto> models = modelService.getAllByThickness(thickness);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByPrice(double price) {
        List<TVModelDto> models = modelService.getAllByPrice(price);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByAvailability(boolean availability) {
        List<TVModelDto> models = modelService.getAllByAvailability(availability);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }
}
