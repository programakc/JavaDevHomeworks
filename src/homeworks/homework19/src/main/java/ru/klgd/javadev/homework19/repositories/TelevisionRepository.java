package ru.klgd.javadev.homework19.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.klgd.javadev.homework19.entities.Television;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
}
