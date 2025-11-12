package ru.klgd.javadev.attestation03.services;

import ru.klgd.javadev.attestation03.entities.User;

import java.time.LocalDate;
import java.util.Optional;

public interface UserService {

    User createUser(String nickname, String password, String fio, Integer age,
                    String email, LocalDate regdate);

    Optional<User> getUserById(Long id);

    User updateUser(Long id, String nickname, String password, String fio,
                    Integer age, String email, LocalDate regdate);

    void deleteUser(Long id);
}
