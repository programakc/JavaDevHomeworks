package ru.klgd.javadev.attestation03.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.klgd.javadev.attestation03.entities.User;
import ru.klgd.javadev.attestation03.repositories.UserRepository;
import ru.klgd.javadev.attestation03.services.UserService;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public User createUser(String nickname, String password, String fio, Integer age,
                           String email, LocalDate regdate) {

        User user = new User(nickname, password, fio, age, email, regdate);
        return userRepository.saveAndFlush(user);
    }

    public Optional<User> getUserById(Long id) {
        User user = userRepository.findById(id).get();

        if (user.getIsDeleted()) {
            throw new NoSuchElementException("Пользователь был удалён!");
        }

        return userRepository.findById(id);
    }

    public User updateUser(Long id, String nickname, String password, String fio,
                           Integer age, String email, LocalDate regdate) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Пользователь " +
                        "не найден!"));

        if (user.getIsDeleted()) {
            throw new NoSuchElementException("Пользователь был удалён!");
        }

        user.setNickname(nickname);
        user.setPassword(password);
        user.setFio(fio);
        user.setAge(age);
        user.setEmail(email);
        user.setRegdate(regdate);

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
