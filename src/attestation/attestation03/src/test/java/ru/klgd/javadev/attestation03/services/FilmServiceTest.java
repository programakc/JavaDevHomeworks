package ru.klgd.javadev.attestation03.services;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.klgd.javadev.attestation03.entities.Film;
import ru.klgd.javadev.attestation03.repositories.FilmRepository;
import ru.klgd.javadev.attestation03.services.impl.FilmServiceImpl;

@ContextConfiguration(classes = {FilmServiceImpl.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class FilmServiceTest {
    @MockitoBean
    private FilmRepository filmRepository;

    @Autowired
    private FilmServiceImpl filmServiceImpl;

    @Test
    void testGetAllFilms() {

        when(filmRepository.findAll()).thenReturn(new ArrayList<>());

        List<Film> actualAllFilms = filmServiceImpl.getAllFilms();

        verify(filmRepository).findAll();
        assertTrue(actualAllFilms.isEmpty());
    }

    @Test
    void testGetFilmByContent_thenReturnEmpty() {

        when(filmRepository.findAll()).thenReturn(new ArrayList<>());

        List<Film> actualFilmByContent = filmServiceImpl.getFilmByContent("Not all who wander are lost");

        verify(filmRepository).findAll();
        assertTrue(actualFilmByContent.isEmpty());
    }

    @Test
    void testGetFilmByGenre_thenReturnEmpty() {

        when(filmRepository.findAll()).thenReturn(new ArrayList<>());

        List<Film> actualFilmByGenre = filmServiceImpl.getFilmByGenre("Genre");

        verify(filmRepository).findAll();
        assertTrue(actualFilmByGenre.isEmpty());
    }

    @Test
    void testGetFilmByRelease_thenReturnEmpty() {

        when(filmRepository.findAll()).thenReturn(new ArrayList<>());

        List<Film> actualFilmByRelease = filmServiceImpl.getFilmByRelease(1);

        verify(filmRepository).findAll();
        assertTrue(actualFilmByRelease.isEmpty());
    }

    @Test
    void testGetFilmByTitle() {

        Film film = new Film();
        film.setContent("Not all who wander are lost");
        film.setGenre("Genre");
        film.setId(1L);
        film.setRelease(1);
        film.setTitle("Dr");
        Optional<Film> ofResult = Optional.of(film);
        when(filmRepository.findByTitle(Mockito.<String>any())).thenReturn(ofResult);

        Optional<Film> actualFilmByTitle = filmServiceImpl.getFilmByTitle("Dr");

        verify(filmRepository).findByTitle(eq("Dr"));
        assertSame(ofResult, actualFilmByTitle);
    }
}
