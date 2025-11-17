package ru.klgd.javadev.attestation03.services;

import ru.klgd.javadev.attestation03.entities.Film;

import java.util.List;
import java.util.Optional;

public interface FilmService {

    List<Film> getAllFilms();

    Optional<Film> getFilmByTitle(String title);

    List<Film> getFilmByGenre(String genre);

    List<Film> getFilmByRelease(Integer release);

    List<Film> getFilmByContent(String content);
}
