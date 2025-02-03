package com.example.equipmentregister.controllers.types;

import com.example.equipmentregister.dto.types.SmartphoneDto;
import com.example.equipmentregister.services.ITypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/equipment/rpc/api/v1/smartphone")
@Tag(name = "Смартфоны")
public class SmartphoneController {
    private final ITypeService<SmartphoneDto> typeService;

    public SmartphoneController(ITypeService<SmartphoneDto> typeService) {
        this.typeService = typeService;
    }

    @Operation(summary = "Добавить вид смартфона")
    @PostMapping(value = "add")
    public ResponseEntity<?> add(@RequestBody @Valid SmartphoneDto smartphoneDto) {
        typeService.add(smartphoneDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Получить все доступные смартфоны")
    @GetMapping(value = "getAllAvailable")
    public ResponseEntity<?> getAllAvailable() {
        List<SmartphoneDto> dtoList = typeService.getAllAvailable();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}
