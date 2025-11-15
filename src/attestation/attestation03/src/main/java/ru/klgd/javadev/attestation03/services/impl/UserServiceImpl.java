package ru.klgd.javadev.attestation03.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.klgd.javadev.attestation03.dto.UserRequest;
import ru.klgd.javadev.attestation03.dto.UserResponse;
import ru.klgd.javadev.attestation03.entities.User;
import ru.klgd.javadev.attestation03.mapper.UserMapper;
import ru.klgd.javadev.attestation03.repositories.UserRepository;
import ru.klgd.javadev.attestation03.services.UserService;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(UserRequest userRequest) {

        User user = userMapper.fromUserCreateRequest(userRequest);
        User savedUser = userRepository.saveAndFlush(user);
        UserResponse userResponse = userMapper.toUserResponse(savedUser);

        return userResponse;
    }

    @Override
    public UserResponse getUserById(Long id) {

        Optional<User> user = userRepository.findById(id);

        if (user.isPresent() && user.get().getIsDeleted()) {
            throw new NoSuchElementException("Пользователь был удалён!");
        }

        return userMapper.toUserResponse(user.get());
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest userRequest) {

        User user;

        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent() && existingUser.get().getIsDeleted()) {
            throw new NoSuchElementException("Пользователь был удалён!");
        }

        if (existingUser.isPresent()) {
            user = existingUser.get();
        } else {
            throw new NoSuchElementException("Пользователь не найден!");
        }


        user.setNickname(userRequest.nickname());
        user.setPassword(userRequest.password());
        user.setFio(userRequest.fio());
        user.setAge(userRequest.age());
        user.setEmail(userRequest.email());

        User updatedUser = userRepository.saveAndFlush(user);

        return userMapper.toUserResponse(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
