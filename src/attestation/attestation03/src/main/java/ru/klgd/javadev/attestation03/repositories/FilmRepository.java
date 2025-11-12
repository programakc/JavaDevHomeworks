package ru.klgd.javadev.attestation03.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.klgd.javadev.attestation03.entities.Film;

import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Long> {

    Optional<Film> findByTitle(String title);
}
