package com.example.equipmentregister.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipment/rpc/api/v1/register")
@Tag(name = "Реестр техники")
public class RegisterController {




    @Operation(summary = "Найти по наименованию, без учета регистра")
    @GetMapping("getByNameCaseInsensitive/{name}")
    public ResponseEntity<?> getTVModels(@PathVariable("name") String name) {
        return new ResponseEntity<>("По запросу: " + name + " ничего не найдено", HttpStatus.OK);
    }
}
