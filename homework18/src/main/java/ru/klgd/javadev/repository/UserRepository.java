package ru.klgd.javadev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.klgd.javadev.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
