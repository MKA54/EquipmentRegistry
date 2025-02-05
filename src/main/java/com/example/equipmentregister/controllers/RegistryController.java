package com.example.equipmentregister.controllers;

import com.example.equipmentregister.dto.RegistryDto;
import com.example.equipmentregister.services.RegistryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/equipment/rpc/api/v1/register")
@Tag(name = "Реестр техники")
@Validated
public class RegistryController {
    private final RegistryService service;

    public RegistryController(RegistryService service) {
        this.service = service;
    }

    @Operation(summary = "Добавить наименование вида техники")
    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody @Valid
                                 RegistryDto registry) {
        service.add(registry);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Получить всю технику в наличии")
    @PostMapping("getAllAvailableModel")
    public ResponseEntity<?> getAllAvailable() {
        List<RegistryDto> registry = service.getAllAvailable();
        return new ResponseEntity<>(registry, HttpStatus.OK);
    }

    @Operation(summary = "Сортировка техники по алфавиту")
    @PostMapping("getAllAlphabetically")
    public ResponseEntity<?> getAllAlphabetically() {
        List<RegistryDto> registry = service.getAllAlphabetically();
        return new ResponseEntity<>(registry, HttpStatus.OK);
    }

    @Operation(summary = "Сортировка техники по стоимости")
    @PostMapping("getAllByOrderByPrice")
    public ResponseEntity<?> getAllByOrderByPrice() {
        List<RegistryDto> registry = service.getAllByOrderByPrice();
        return new ResponseEntity<>(registry, HttpStatus.OK);
    }
}
