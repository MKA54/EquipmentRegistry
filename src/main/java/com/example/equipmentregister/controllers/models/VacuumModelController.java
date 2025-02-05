package com.example.equipmentregister.controllers.models;

import com.example.equipmentregister.controllers.BaseModelController;
import com.example.equipmentregister.dto.models.VacuumModelDto;
import com.example.equipmentregister.services.modelImpl.VacuumModelServiceImpl;
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
@RequestMapping("/equipment/rpc/api/v1/vacuum/model")
@Tag(name = "Модели пылесосов", description = "Возможные операции с моделями: добавление, получение по параметру и получить всё")
public class VacuumModelController implements BaseModelController {
    private final VacuumModelServiceImpl modelService;

    public VacuumModelController(VacuumModelServiceImpl modelService) {
        this.modelService = modelService;
    }

    @Operation(summary = "Добавить модель")
    @PostMapping("add")
    public ResponseEntity<?> add(@Valid VacuumModelDto model) {
        modelService.add(model);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Получить все модели по объёму пылесборника")
    @GetMapping(value = "getAllByDustContainerVolume/{dustContainerVolume}")
    @ApiResponse(responseCode = "400", description = "Неверный запрос — объём пылесборника не может быть отрицательным")
    ResponseEntity<?> getAllByDustContainerVolume(@PathVariable("dustContainerVolume")
                                                  @Parameter(description = "Объём пылесборника")
                                                  @Min(0) double dustContainerVolume) {
        List<VacuumModelDto> models = modelService.getAllByDustContainerVolume(dustContainerVolume);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Operation(summary = "Получить все модели по количеству режимов")
    @GetMapping(value = "getAllByModesCount/{modesCount}")
    @ApiResponse(responseCode = "400", description = "Неверный запрос — количество режимов не может быть отрицательным")
    ResponseEntity<?> getAllByModesCount(@PathVariable("modesCount")
                                         @Parameter(description = "Количество режимов")
                                         @Min(0) int modesCount) {
        List<VacuumModelDto> models = modelService.getAllByModesCount(modesCount);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<VacuumModelDto> models = modelService.getAll();
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByNameLikeIgnoreCase(String name) {
        List<VacuumModelDto> models = modelService.getAllByNameCaseInsensitive(name);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllBySerialNumberLikeIgnoreCase(String serialNumber) {
        List<VacuumModelDto> models = modelService.getAllBySerialNumberLikeIgnoreCase(serialNumber);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByColorLikeIgnoreCase(String color) {
        List<VacuumModelDto> models = modelService.getAllByColorLikeIgnoreCase(color);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByLength(double length) {
        List<VacuumModelDto> models = modelService.getAllByLength(length);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByWidth(double width) {
        List<VacuumModelDto> models = modelService.getAllByWidth(width);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByThickness(double thickness) {
        List<VacuumModelDto> models = modelService.getAllByThickness(thickness);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByPrice(double price) {
        List<VacuumModelDto> models = modelService.getAllByPrice(price);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllByAvailability(boolean availability) {
        List<VacuumModelDto> models = modelService.getAllByAvailability(availability);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }
}
