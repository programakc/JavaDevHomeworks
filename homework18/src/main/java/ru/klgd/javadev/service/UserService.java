package ru.klgd.javadev.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.klgd.javadev.entity.User;
import ru.klgd.javadev.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User updateUser(User user) {
        User entity = repository.findById(user.getId())
                .orElseThrow(() -> new NoSuchElementException("Пользователь " +
                        "не найден"));

        return repository.saveAndFlush(entity);
    }

}
