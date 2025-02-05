package com.example.equipmentregister.controllers.types;

import com.example.equipmentregister.dto.types.VacuumDto;
import com.example.equipmentregister.services.ITypeService;
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
@RequestMapping("/equipment/rpc/api/v1/vacuum")
@Tag(name = "Пылесосы")
public class VacuumController {
    private final ITypeService<VacuumDto> typeService;

    public VacuumController(ITypeService<VacuumDto> typeService) {
        this.typeService = typeService;
    }

    @Operation(summary = "Добавить позицию")
    @PostMapping(value = "add")
    public ResponseEntity<?> add(@RequestBody @Valid VacuumDto vacuumDto) {
        typeService.add(vacuumDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Получить все позиции с доступными моделями")
    @GetMapping(value = "getAllAvailable")
    public ResponseEntity<?> getAllAvailable() {
        List<VacuumDto> dtoList = typeService.getAllAvailable();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}
