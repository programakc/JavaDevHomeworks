package ru.klgd.javadev.attestation03.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.klgd.javadev.attestation03.entities.Film;
import ru.klgd.javadev.attestation03.repositories.FilmRepository;
import ru.klgd.javadev.attestation03.services.FilmService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Optional<Film> getFilmByTitle(String title) {
        return filmRepository.findByTitle(title);
    }

    public List<Film> getFilmByGenre(String genre) {
        return filmRepository.findAll().stream()
                .filter(film -> film.getGenre().equals(genre))
                .collect(Collectors.toList());
    }

    public List<Film> getFilmByRelease(Integer release) {
        return filmRepository.findAll().stream()
                .filter(film -> film.getRelease().equals(release))
                .collect(Collectors.toList());
    }

    public List<Film> getFilmByContent(String content) {
        return filmRepository.findAll().stream()
                .filter(film -> film.getContent().equals(content))
                .collect(Collectors.toList());
    }
}
