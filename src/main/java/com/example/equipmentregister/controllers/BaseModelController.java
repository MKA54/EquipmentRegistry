package com.example.equipmentregister.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Validated
public interface BaseModelController {
    @Operation(summary = "Получить все модели")
    @GetMapping("getAll")
    ResponseEntity<?> getAll();

    @Operation(summary = "Получить все модели по наименованию, без учета регистра")
    @GetMapping(value = "getAllByNameLikeIgnoreCase/{name}")
    @ApiResponse(responseCode = "400", description = "Неверный запрос — наименование не может быть пустым или null")
    ResponseEntity<?> getAllByNameLikeIgnoreCase(@PathVariable("name")
                                                 @Parameter(description = "Наименование")
                                                 @NotNull @NotEmpty @NotBlank String name);

    @Operation(summary = "Получить все модели по серийному номеру, без учета регистра")
    @GetMapping(value = "getAllBySerialNumberLikeIgnoreCase/{serialNumber}")
    @ApiResponse(responseCode = "400", description = "Неверный запрос — серийный номер не может быть пустым или null")
    ResponseEntity<?> getAllBySerialNumberLikeIgnoreCase(@PathVariable("serialNumber")
                                                         @Parameter(description = "Сериный номер")
                                                         @NotNull @NotEmpty @NotBlank String serialNumber);

    @Operation(summary = "Получить все модели по цвету, без учета регистра")
    @GetMapping(value = "getAllByColorLikeIgnoreCase/{color}")
    @ApiResponse(responseCode = "400", description = "Неверный запрос — цвет не может быть пустым или null")
    ResponseEntity<?> getAllByColorLikeIgnoreCase(@PathVariable("color")
                                                  @Parameter(description = "Цвет")
                                                  @NotNull @NotEmpty @NotBlank String color);

    @Operation(summary = "Получить все модели по длине")
    @GetMapping(value = "getAllByLength/{length}")
    @ApiResponse(responseCode = "400", description = "Неверный запрос — длина не может быть отрицательной")
    ResponseEntity<?> getAllByLength(@PathVariable("length")
                                     @Parameter(description = "Длина")
                                     @Min(value = 0, message = "Длина не может быть отрицательной") double length);

    @Operation(summary = "Получить все модели по ширине")
    @GetMapping(value = "getAllByWidth/{width}")
    @ApiResponse(responseCode = "400", description = "Неверный запрос — ширина не может быть отрицательной")
    ResponseEntity<?> getAllByWidth(@PathVariable("width") @Min(value = 0, message = "Ширина не может быть отрицательной")
                                    @Parameter(description = "Ширина")
                                    double width);

    @Operation(summary = "Получить все модели по глубине")
    @GetMapping(value = "getAllByThickness/{thickness}")
    @ApiResponse(responseCode = "400", description = "Неверный запрос — глубина не может быть отрицательной")
    ResponseEntity<?> getAllByThickness(@PathVariable("thickness")
                                        @Parameter(description = "Глубина")
                                        @Min(value = 0, message = "Глубина не может быть отрицательной") double thickness);

    @Operation(summary = "Получить все модели по цене")
    @GetMapping(value = "getAllByPrice/{price}")
    @ApiResponse(responseCode = "400", description = "Неверный запрос — цена не может быть отрицательной")
    ResponseEntity<?> getAllByPrice(@PathVariable("price")
                                    @Parameter(description = "Цена")
                                    @Min(value = 0, message = "Цена не может быть отрицательной") double price);

    @Operation(summary = "Получить все модели по параметру наличие")
    @GetMapping(value = "getAllByAvailability/{availability}")
    ResponseEntity<?> getAllByAvailability(@PathVariable("availability")
                                           @Parameter(description = "Наличие")
                                           boolean availability);
}
