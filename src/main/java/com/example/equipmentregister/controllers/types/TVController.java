package com.example.equipmentregister.controllers.types;

import com.example.equipmentregister.dto.types.TVDto;
import com.example.equipmentregister.services.ITypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/equipment/rpc/api/v1/tv")
@Tag(name = "Телевизоры")
public class TVController {
    private final ITypeService<TVDto> typeService;

    public TVController(ITypeService<TVDto> typeService) {
        this.typeService = typeService;
    }

    @Operation(summary = "Добавить вид телевизора")
    @PostMapping(value = "add")
    public ResponseEntity<?> add(@RequestBody @Valid TVDto tvDto) {
        typeService.add(tvDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Получить все доступные телевизоры")
    @GetMapping(value = "getAllAvailable")
    public ResponseEntity<?> getAllAvailable() {
        List<TVDto> dtoList = typeService.getAllAvailable();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}
