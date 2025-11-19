package ru.klgd.javadev.attestation03.controllers;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.klgd.javadev.attestation03.entities.Film;
import ru.klgd.javadev.attestation03.services.impl.FilmServiceImpl;

@ContextConfiguration(classes = {FilmController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
public class FilmControllerTest {

    @Autowired
    private FilmController filmController;

    @MockitoBean
    private FilmServiceImpl filmServiceImpl;

    @Test
    void testGetAllFilms() throws Exception {

        when(filmServiceImpl.getAllFilms()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cinema/film");

        MockMvcBuilders.standaloneSetup(filmController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetFilmByContent() throws Exception {

        when(filmServiceImpl.getFilmByContent(Mockito.<String>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cinema/film/content/{content}",
                "Not all who wander are lost");

        MockMvcBuilders.standaloneSetup(filmController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetFilmByGenre() throws Exception {

        when(filmServiceImpl.getFilmByGenre(Mockito.<String>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cinema/film/genre/{genre}", "Genre");

        MockMvcBuilders.standaloneSetup(filmController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetFilmByRelease() throws Exception {

        when(filmServiceImpl.getFilmByRelease(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                String.join("", "/cinema/film/", System.getProperty("jdk.debug"),
                        "/{", System.getProperty("jdk.debug"), "}"), 1);

        MockMvcBuilders.standaloneSetup(filmController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetFilmByTitle() throws Exception {

        Film film = new Film();
        film.setContent("Not all who wander are lost");
        film.setGenre("Genre");
        film.setId(1L);
        film.setRelease(1);
        film.setTitle("Dr");
        Optional<Film> ofResult = Optional.of(film);
        when(filmServiceImpl.getFilmByTitle(Mockito.<String>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cinema/film/title/{title}", "Dr");

        ResultActions resultActions = MockMvcBuilders.standaloneSetup(filmController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(String.join("", "{\"id\":1,\"title\":\"Dr\",\"genre\":\"Genre\",\"",
                System.getProperty("jdk.debug"), "\":1,\"content\":\"Not all who wander are lost\"}")));
    }
}
