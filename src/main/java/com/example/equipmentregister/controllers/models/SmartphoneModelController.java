package com.example.equipmentregister.controllers.models;

import com.example.equipmentregister.controllers.BaseModelController;
import com.example.equipmentregister.dto.models.SmartphoneModelDto;
import com.example.equipmentregister.services.modelImpl.SmartphoneModelServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/equipment/rpc/api/v1/smartphone/model")
@Tag(name = "Модели смартфонов", description = "Возможные операции с моделями: добавление, получение по параметру и получить всё")
public class SmartphoneModelController implements BaseModelController {
    private final SmartphoneModelServiceImpl modelService;

    public SmartphoneModelController(SmartphoneModelServiceImpl modelService) {
        this.modelService = modelService;
    }

    @Operation(summary = "Добавить модель")
    @PostMapping("add")
    public ResponseEntity<?> add(@Valid SmartphoneModelDto model) {
        modelService.add(model);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Получить все модели по размеру памяти")
    @GetMapping(value = "getAllByMemory/{memory}")
    @ApiResponse(responseCode = "400", description = "Неверный запрос — память не может быть отрицательной")
    ResponseEntity<?> getAllByMemory(@PathVariable("memory")
                                     @Parameter(description = "Память")
                                     @Min(0) int memory) {
        List<SmartphoneModelDto> models = modelService.getAllByMemory(memory);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Operation(summary = "Получить все модели по количеству камер")
    @GetMapping(value = "getAllByByCamerasCount/{camerasCount}")
    @ApiResponse(responseCode = "400", description = "Неверный запрос — количество камер не может быть отрицательным")
    ResponseEntity<?> getAllByByCamerasCount(@PathVariable("camerasCount")
                                             @Parameter(description = "Количество камер")
                                             @Min(0) int camerasCount) {
        List<SmartphoneModelDto> models = modelService.getAllByByCamerasCount(camerasCount);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<SmartphoneModelDto> models = modelService.getAll();
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByNameLikeIgnoreCase(String name) {
        List<SmartphoneModelDto> models = modelService.getAllByNameCaseInsensitive(name);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllBySerialNumberLikeIgnoreCase(String serialNumber) {
        List<SmartphoneModelDto> models = modelService.getAllBySerialNumberLikeIgnoreCase(serialNumber);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByColorLikeIgnoreCase(String color) {
        List<SmartphoneModelDto> models = modelService.getAllByColorLikeIgnoreCase(color);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByLength(double length) {
        List<SmartphoneModelDto> models = modelService.getAllByLength(length);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByWidth(double width) {
        List<SmartphoneModelDto> models = modelService.getAllByWidth(width);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByThickness(double thickness) {
        List<SmartphoneModelDto> models = modelService.getAllByThickness(thickness);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByPrice(double price) {
        List<SmartphoneModelDto> models = modelService.getAllByPrice(price);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByAvailability(boolean availability) {
        List<SmartphoneModelDto> models = modelService.getAllByAvailability(availability);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }
}
