package ru.klgd.javadev.homework19.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.klgd.javadev.homework19.Service.Impl.TelevisionServiceImpl;
import ru.klgd.javadev.homework19.dto.TelevisionRequest;
import ru.klgd.javadev.homework19.dto.TelevisionResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/store/tv")
public class TelevisionController {

    private final TelevisionServiceImpl televisionService;

    @Operation(summary = "Создание новой записи в таблице televisions",
            description = "В ответе возвращается объект TelevisionResponse c " +
                    "полями company, model, release, price и countInStock.")
    @PostMapping
    public ResponseEntity<TelevisionResponse> createTelevision(@RequestBody TelevisionRequest televisionRequest) {
        TelevisionResponse newTelevision = televisionService.createTelevision(televisionRequest);

        return new ResponseEntity<>(newTelevision, HttpStatus.CREATED);
    }

    @Operation(summary = "Поиск телевизора по ID",
            description = "Если телевизор найден, то в ответе возвращается " +
                    "объект TelevisionResponse c полями company, model, release, price и countInStock.")
    @GetMapping("/{id}")
    public ResponseEntity<TelevisionResponse> getTelevisionById(
            @Parameter(description = "ID телевизора, данные по которому запрашиваются", required = true)
            @PathVariable Long id) {

        TelevisionResponse television = televisionService.getTelevisionById(id);

        return new ResponseEntity<>(television, HttpStatus.OK);
    }

    @Operation(summary = "Обновление данных о телевизоре, найденному по ID",
            description = "Если телевизор найден, то в ответе возвращается " +
                    "объект TelevisionResponse c обновлёнными полями company, model, release, price и countInStock.")
    @PutMapping("/{id}")
    public ResponseEntity<TelevisionResponse> updateTelevision(
            @Parameter(description = "ID телевизора, данные которого необходимо обновить", required = true)
            @PathVariable Long id, @RequestBody TelevisionRequest televisionRequest){

        TelevisionResponse updatedTelevision = televisionService.updateTelevision(id, televisionRequest);
        return new ResponseEntity<>(updatedTelevision, HttpStatus.OK);
    }

    @Operation(summary = "Обновление данных о телевизоре, найденному по ID",
            description = "В ответе возвращается пустое тело запроса")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(
            @Parameter(description = "ID телевизора, который требуется удалить", required = true)
            @PathVariable Long id) {

        televisionService.deleteTelevision(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
