package ru.klgd.javadev.attestation03.services;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.klgd.javadev.attestation03.dto.UserRequest;
import ru.klgd.javadev.attestation03.dto.UserResponse;
import ru.klgd.javadev.attestation03.entities.User;
import ru.klgd.javadev.attestation03.mapper.UserMapper;
import ru.klgd.javadev.attestation03.repositories.UserRepository;
import ru.klgd.javadev.attestation03.services.impl.UserServiceImpl;

@ContextConfiguration(classes = {UserServiceImpl.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @MockitoBean
    private UserMapper userMapper;

    @MockitoBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    void testCreateUser() {

        User user = new User();
        user.setAge(1);
        user.setEmail("jane.doe@example.org");
        user.setFio("Fio");
        user.setId(1L);
        user.setIsDeleted(true);
        user.setNickname("Nickname");
        user.setPassword("iloveyou");
        user.setRegdate(LocalDate.of(1970, 1, 1));
        when(userRepository.saveAndFlush(Mockito.<User>any())).thenReturn(user);

        User user2 = new User();
        user2.setAge(1);
        user2.setEmail("jane.doe@example.org");
        user2.setFio("Fio");
        user2.setId(1L);
        user2.setIsDeleted(true);
        user2.setNickname("Nickname");
        user2.setPassword("iloveyou");
        user2.setRegdate(LocalDate.of(1970, 1, 1));
        UserResponse userResponse = new UserResponse("Nickname", "Fio", 1, "jane.doe@example.org",
                LocalDate.of(1970, 1, 1));

        when(userMapper.toUserResponse(Mockito.<User>any())).thenReturn(userResponse);
        when(userMapper.fromUserCreateRequest(Mockito.<UserRequest>any())).thenReturn(user2);

        UserResponse actualCreateUserResult = userServiceImpl.createUser(
                new UserRequest(1L, "Nickname", "iloveyou", "Fio", 1, "jane.doe@example.org", LocalDate.of(1970, 1, 1), true));

        verify(userRepository).saveAndFlush(isA(User.class));
        verify(userMapper).fromUserCreateRequest(isA(UserRequest.class));
        verify(userMapper).toUserResponse(isA(User.class));
        assertSame(userResponse, actualCreateUserResult);
    }

    @Test
    void testGetUserById() {

        User user = new User();
        user.setAge(1);
        user.setEmail("jane.doe@example.org");
        user.setFio("Fio");
        user.setId(1L);
        user.setIsDeleted(true);
        user.setNickname("Nickname");
        user.setPassword("iloveyou");
        user.setRegdate(LocalDate.of(1970, 1, 1));
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        assertThrows(NoSuchElementException.class, () -> userServiceImpl.getUserById(1L));
        verify(userRepository).findById(eq(1L));
    }

    @Test
    void testUpdateUser() {

        User user = new User();
        user.setAge(1);
        user.setEmail("jane.doe@example.org");
        user.setFio("Fio");
        user.setId(1L);
        user.setIsDeleted(true);
        user.setNickname("Nickname");
        user.setPassword("iloveyou");
        user.setRegdate(LocalDate.of(1970, 1, 1));
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        assertThrows(NoSuchElementException.class, () -> userServiceImpl.updateUser(1L,
                new UserRequest(1L, "Nickname", "iloveyou", "Fio", 1, "jane.doe@example.org", LocalDate.of(1970, 1, 1), true)));
        verify(userRepository).findById(eq(1L));
    }

    @Test
    void testDeleteUser() {

        doNothing().when(userRepository).deleteById(Mockito.<Long>any());

        userServiceImpl.deleteUser(1L);

        verify(userRepository).deleteById(eq(1L));
    }
}
