package ru.klgd.javadev.attestation03.services;

import ru.klgd.javadev.attestation03.dto.UserRequest;
import ru.klgd.javadev.attestation03.dto.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest userRequest);

    UserResponse getUserById(Long id);

    UserResponse updateUser(Long id, UserRequest userRequest);

    void deleteUser(Long id);
}
