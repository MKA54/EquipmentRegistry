package com.example.equipmentregister.controllers;

import com.example.equipmentregister.dao.types.TVRepository;
import com.example.equipmentregister.dto.types.TVDto;
import com.example.equipmentregister.models.types.TV;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/equipment/rpc/api/v1/tv")
@Tag(name = "Телевизоры")
public class TVController {
    private final TVRepository tvRepository;

    public TVController(TVRepository tvRepository) {
        this.tvRepository = tvRepository;
    }

    @Operation(summary = "Добавить вид телевизора")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody @Valid TVDto tvDto) {

        tvRepository.save(new TV(tvDto.getName(),
                tvDto.getManufactureCountry(),
                tvDto.getManufacturer(),
                tvDto.isPossibilityOrderingOnline(),
                tvDto.isPaymentByInstalments()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Получить все доступные телевизоры")
    @RequestMapping(value = "getAllAvailableTV", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getAllAvailableTV() {
        List<TV> repo = tvRepository.findAll();

        return new ResponseEntity<>(repo, HttpStatus.OK);
    }
}
