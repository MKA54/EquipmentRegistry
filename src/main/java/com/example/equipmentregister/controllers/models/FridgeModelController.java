package com.example.equipmentregister.controllers.models;

import com.example.equipmentregister.controllers.BaseModelController;
import com.example.equipmentregister.dto.models.FridgeModelDto;
import com.example.equipmentregister.services.modelImpl.FridgeModelServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/equipment/rpc/api/v1/fridge/model")
@Tag(name = "Модели холодильников", description = "Возможные операции с моделями: добавление, получение по параметру и получить всё")
public class FridgeModelController implements BaseModelController {
    private final FridgeModelServiceImpl modelService;

    public FridgeModelController(FridgeModelServiceImpl modelService) {
        this.modelService = modelService;
    }

    @Operation(summary = "Добавить модель")
    @PostMapping("add")
    public ResponseEntity<?> add(@Valid FridgeModelDto model) {
        modelService.add(model);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Получить все модели по количеству дверей")
    @GetMapping(value = "getAllByDoorsCount/{doorsCount}")
    @ApiResponse(responseCode = "400", description = "Неверный запрос — количество дверей не может быть отрицательным")
    ResponseEntity<?> getAllByDoorsCount(@PathVariable("doorsCount")
                                         @Parameter(description = "Количество дверей")
                                         @Min(0) int doorsCount) {
        List<FridgeModelDto> models = modelService.getAllByDoorsCount(doorsCount);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Operation(summary = "Получить все модели по типу компрессора")
    @GetMapping(value = "getAllByCompressorTypeLikeIgnoreCase/{compressorType}")
    @ApiResponse(responseCode = "400", description = "Неверный запрос — тип компрессора не может быть пустым или null")
    ResponseEntity<?> getAllByCompressorTypeLikeIgnoreCase(@PathVariable("compressorType")
                                                           @Parameter(description = "Тип компрессора")
                                                           @NotNull @NotEmpty @NotBlank String compressorType) {
        List<FridgeModelDto> models = modelService.getAllByCompressorTypeLikeIgnoreCase(compressorType);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<FridgeModelDto> models = modelService.getAll();
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByNameLikeIgnoreCase(String name) {
        List<FridgeModelDto> models = modelService.getAllByNameCaseInsensitive(name);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllBySerialNumberLikeIgnoreCase(String serialNumber) {
        List<FridgeModelDto> models = modelService.getAllBySerialNumberLikeIgnoreCase(serialNumber);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByColorLikeIgnoreCase(String color) {
        List<FridgeModelDto> models = modelService.getAllByColorLikeIgnoreCase(color);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByLength(double length) {
        List<FridgeModelDto> models = modelService.getAllByLength(length);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByWidth(double width) {
        List<FridgeModelDto> models = modelService.getAllByWidth(width);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByThickness(double thickness) {
        List<FridgeModelDto> models = modelService.getAllByThickness(thickness);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByPrice(double price) {
        List<FridgeModelDto> models = modelService.getAllByPrice(price);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByAvailability(boolean availability) {
        List<FridgeModelDto> models = modelService.getAllByAvailability(availability);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }
}
