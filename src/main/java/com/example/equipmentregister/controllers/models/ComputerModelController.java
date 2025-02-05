package com.example.equipmentregister.controllers.models;

import com.example.equipmentregister.controllers.BaseModelController;
import com.example.equipmentregister.dto.models.ComputerModelDto;
import com.example.equipmentregister.services.modelImpl.ComputerModelServiceImpl;
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
@RequestMapping("/equipment/rpc/api/v1/computer/model")
@Tag(name = "Модели компьютеров", description = "Возможные операции с моделями: добавление, получение по параметру и получить всё")
public class ComputerModelController implements BaseModelController {
    private final ComputerModelServiceImpl modelService;

    public ComputerModelController(ComputerModelServiceImpl modelService) {
        this.modelService = modelService;
    }

    @Operation(summary = "Добавить модель")
    @PostMapping("add")
    public ResponseEntity<?> add(@Valid ComputerModelDto model) {
        modelService.add(model);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Получить все модели по категории")
    @GetMapping(value = "getAllByCategoryLikeIgnoreCase/{category}")
    @ApiResponse(responseCode = "400", description = "Неверный запрос — количество дверей не может быть отрицательным")
    ResponseEntity<?> getAllByCategoryLikeIgnoreCase(@PathVariable("category")
                                                     @Parameter(description = "Категория")
                                                     @NotBlank @NotEmpty @NotNull String category) {
        List<ComputerModelDto> models = modelService.getAllByCategoryLikeIgnoreCase(category);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Operation(summary = "Получить все модели по типу процесса")
    @GetMapping(value = "getAllByProcessorTypeLikeIgnoreCase/{processorType}")
    @ApiResponse(responseCode = "400", description = "Неверный запрос — тип процессора не может быть пустым или null")
    ResponseEntity<?> getAllByProcessorTypeLikeIgnoreCase(@PathVariable("processorType")
                                                          @Parameter(description = "Тип процессора")
                                                          @NotBlank @NotEmpty @NotNull String processorType) {
        List<ComputerModelDto> models = modelService.getAllByProcessorTypeLikeIgnoreCase(processorType);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<ComputerModelDto> models = modelService.getAll();
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByNameLikeIgnoreCase(String name) {
        List<ComputerModelDto> models = modelService.getAllByNameCaseInsensitive(name);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllBySerialNumberLikeIgnoreCase(String serialNumber) {
        List<ComputerModelDto> models = modelService.getAllBySerialNumberLikeIgnoreCase(serialNumber);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByColorLikeIgnoreCase(String color) {
        List<ComputerModelDto> models = modelService.getAllByColorLikeIgnoreCase(color);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByLength(double length) {
        List<ComputerModelDto> models = modelService.getAllByLength(length);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByWidth(double width) {
        List<ComputerModelDto> models = modelService.getAllByWidth(width);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByThickness(double thickness) {
        List<ComputerModelDto> models = modelService.getAllByThickness(thickness);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByPrice(double price) {
        List<ComputerModelDto> models = modelService.getAllByPrice(price);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByAvailability(boolean availability) {
        List<ComputerModelDto> models = modelService.getAllByAvailability(availability);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }
}
