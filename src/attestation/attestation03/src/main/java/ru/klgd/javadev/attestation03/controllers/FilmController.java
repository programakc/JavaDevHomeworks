package ru.klgd.javadev.attestation03.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.klgd.javadev.attestation03.entities.Film;
import ru.klgd.javadev.attestation03.services.impl.FilmServiceImpl;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cinema/film")
public class FilmController {

    private final FilmServiceImpl filmService;

    @GetMapping
    public ResponseEntity<List<Film>> getAllFilms() {
        return ResponseEntity.ok(filmService.getAllFilms());
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Film> getFilmByTitle(@PathVariable String title) {
        return filmService.getFilmByTitle(title)
                .map(film -> new ResponseEntity<>(film, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Film>> getFilmByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(filmService.getFilmByGenre(genre));
    }

    @GetMapping("/release/{release}")
    public ResponseEntity<List<Film>> getFilmByRelease(@PathVariable Integer release) {
        return ResponseEntity.ok(filmService.getFilmByRelease(release));
    }

    @GetMapping("/content/{content}")
    public ResponseEntity<List<Film>> getFilmByContent(@PathVariable String content) {
        return ResponseEntity.ok(filmService.getFilmByContent(content));
    }
}
