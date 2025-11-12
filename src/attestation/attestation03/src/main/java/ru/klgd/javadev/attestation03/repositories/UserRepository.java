package ru.klgd.javadev.attestation03.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.klgd.javadev.attestation03.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
