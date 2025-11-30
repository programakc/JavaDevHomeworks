package ru.klgd.javadev.attestation03.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

    @Operation(summary = "Получение всей библиотеки фильмов",
            description = "В ответе возвращается список объектов Film, " +
                    "содержащий всю базу фильмов ресурса")
    @GetMapping
    public ResponseEntity<List<Film>> getAllFilms() {
        return ResponseEntity.ok(filmService.getAllFilms());
    }

    @Operation(summary = "Получение фильма по названию",
            description = "В ответе возвращается объект Film, найденный по " +
                    "полю title")
    @GetMapping("/title/{title}")
    public ResponseEntity<Film> getFilmByTitle(
            @Parameter(description = "Название фильма", required = true)
            @PathVariable String title) {

        return filmService.getFilmByTitle(title)
                .map(film -> new ResponseEntity<>(film, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Получение списка фильмов по жанру",
            description = "В ответе возвращается список объектов Film, " +
                    "найденные по полю genre")
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Film>> getFilmByGenre(
            @Parameter(description = "Жанр фильма", required = true)
            @PathVariable String genre) {

        return ResponseEntity.ok(filmService.getFilmByGenre(genre));
    }

    @Operation(summary = "Получение списка фильмов по дате выпуска",
            description = "В ответе возвращается список объектов Film, " +
                    "найденные по полю release")
    @GetMapping("/release/{release}")
    public ResponseEntity<List<Film>> getFilmByRelease(
            @Parameter(description = "Дата выпуска фильма", required = true)
            @PathVariable Integer release) {

        return ResponseEntity.ok(filmService.getFilmByRelease(release));
    }

    @Operation(summary = "Получение списка фильмов или сериалов",
            description = "В ответе возвращается список объектов Film, " +
                    "найденные по полю content")
    @GetMapping("/content/{content}")
    public ResponseEntity<List<Film>> getFilmByContent(
            @Parameter(description = "Жанр фильма", required = true)
            @PathVariable String content) {

        return ResponseEntity.ok(filmService.getFilmByContent(content));
    }
}
