package com.example.equipmentregister.controllers.types;

import com.example.equipmentregister.dto.types.ComputerDto;
import com.example.equipmentregister.services.ITypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/equipment/rpc/api/v1/computer")
@Tag(name = "Компьютеры")
public class ComputerController {
    private final ITypeService<ComputerDto> typeService;

    public ComputerController(ITypeService<ComputerDto> typeService) {
        this.typeService = typeService;
    }

    @Operation(summary = "Добавить вид компютера")
    @PostMapping(value = "add")
    public ResponseEntity<?> add(@RequestBody @Valid ComputerDto computerDto) {
        typeService.add(computerDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Получить все доступные компютеры")
    @GetMapping(value = "getAllAvailable")
    public ResponseEntity<?> getAllAvailable() {
        List<ComputerDto> dtoList = typeService.getAllAvailable();

        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}
