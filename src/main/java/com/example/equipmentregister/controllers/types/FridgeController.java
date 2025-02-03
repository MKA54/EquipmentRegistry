package com.example.equipmentregister.controllers.types;

import com.example.equipmentregister.dto.types.FridgeDto;
import com.example.equipmentregister.services.ITypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/equipment/rpc/api/v1/fridge")
@Tag(name = "Холодильники")
public class FridgeController {
    private final ITypeService<FridgeDto> typeService;

    public FridgeController(ITypeService<FridgeDto> typeService) {
        this.typeService = typeService;
    }

    @Operation(summary = "Добавить вид холодильника")
    @PostMapping(value = "add")
    public ResponseEntity<?> add(@RequestBody @Valid FridgeDto fridgeDto) {
        typeService.add(fridgeDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Получить все доступные холодильники")
    @GetMapping(value = "getAllAvailable")
    public ResponseEntity<?> getAllAvailable() {
        List<FridgeDto> dtoList = typeService.getAllAvailable();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }
}
