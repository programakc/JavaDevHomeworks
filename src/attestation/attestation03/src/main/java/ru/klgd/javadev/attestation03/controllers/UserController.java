package ru.klgd.javadev.attestation03.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.klgd.javadev.attestation03.dto.UserRequest;
import ru.klgd.javadev.attestation03.dto.UserResponse;
import ru.klgd.javadev.attestation03.services.impl.UserServiceImpl;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cinema/user")
public class UserController {

    private final UserServiceImpl userService;

    @Operation(summary = "Создание нового пользователя",
            description = "В ответе возвращается объект UserResponse, в базу " +
                    "данных пользователей добавлен новый элемент")
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        UserResponse newUser = userService.createUser(userRequest);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Получение данных пользователя по ID",
            description = "В ответе возвращается объект UserResponse, " +
                    "содержащий данные пользователя, найденного по ID")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(
            @Parameter(description = "ID пользователя, которого ищем", required = true)
            @PathVariable Long id) {

        UserResponse user = userService.getUserById(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(summary = "Обновление данных пользователя, найденного по ID",
            description = "В ответе возвращается объект UserResponse, " +
                    "содержащий обновлённые данные пользователя, найденного по ID")
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @Parameter(description = "ID пользователя, данные которого необходимо обновить", required = true)
            @PathVariable Long id,
            @RequestBody UserRequest userRequest){

        UserResponse updatedUser = userService.updateUser(id, userRequest);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @Operation(summary = "Удаление пользователя, найденного по ID",
            description = "В ответе возвращается пустое тело запроса")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @Parameter(description = "ID пользователя, которого необходимо удалить", required = true)
            @PathVariable Long id) {

        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
