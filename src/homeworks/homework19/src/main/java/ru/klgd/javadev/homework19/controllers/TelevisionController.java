package ru.klgd.javadev.homework19.controllers;

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

    @PostMapping
    public ResponseEntity<TelevisionResponse> createTelevision(@RequestBody TelevisionRequest televisionRequest) {
        TelevisionResponse newTelevision = televisionService.createTelevision(televisionRequest);

        return new ResponseEntity<>(newTelevision, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionResponse> getTelevisionById(@PathVariable Long id) {
        TelevisionResponse television = televisionService.getTelevisionById(id);

        return new ResponseEntity<>(television, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionResponse> updateTelevision(@PathVariable Long id,
                                                   @RequestBody TelevisionRequest televisionRequest){

        TelevisionResponse updatedTelevision = televisionService.updateTelevision(id, televisionRequest);
        return new ResponseEntity<>(updatedTelevision, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
