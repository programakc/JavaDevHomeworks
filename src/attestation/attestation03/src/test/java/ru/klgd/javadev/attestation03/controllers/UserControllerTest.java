package ru.klgd.javadev.attestation03.controllers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.klgd.javadev.attestation03.dto.UserRequest;
import ru.klgd.javadev.attestation03.dto.UserResponse;
import ru.klgd.javadev.attestation03.services.impl.UserServiceImpl;

@ContextConfiguration(classes = {UserController.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @MockitoBean
    private UserServiceImpl userServiceImpl;

    @Test
    void testCreateUser() throws Exception {

        when(userServiceImpl.createUser(Mockito.<UserRequest>any()))
                .thenReturn(new UserResponse("Nickname", "Fio", 1, "jane.doe@example.org", LocalDate.of(1970, 1, 1)));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/cinema/user")
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new UserRequest(1L, "Nickname", "iloveyou", "Fio", 1,
                        "jane.doe@example.org", null, true)));

        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"nickname\":\"Nickname\",\"fio\":\"Fio\",\"age\"" +
                                        ":1,\"email\":\"jane.doe@example.org\",\"regdate\":[1970,1,1]}"));
    }

    @Test
    void testDeleteUser() throws Exception {

        doNothing().when(userServiceImpl).deleteUser(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/cinema/user/{id}", 1L);

        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void testGetUserById() throws Exception {

        when(userServiceImpl.getUserById(Mockito.<Long>any()))
                .thenReturn(new UserResponse("Nickname", "Fio", 1, "jane.doe@example.org", LocalDate.of(1970, 1, 1)));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cinema/user/{id}", 1L);

        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"nickname\":\"Nickname\",\"fio\":\"Fio\",\"age\":1,\"" +
                                        "email\":\"jane.doe@example.org\",\"regdate\":[1970,1,1]}"));
    }

    @Test
    void testUpdateUser() throws Exception {

        when(userServiceImpl.updateUser(Mockito.<Long>any(), Mockito.<UserRequest>any()))
                .thenReturn(new UserResponse("Nickname", "Fio", 1, "jane.doe@example.org", LocalDate.of(1970, 1, 1)));
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.put("/cinema/user/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult.content(objectMapper
                .writeValueAsString(new UserRequest(1L, "Nickname", "iloveyou",
                        "Fio", 1, "jane.doe@example.org", null, true)));

        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"nickname\":\"Nickname\",\"fio\":\"Fio\",\"age\":1," +
                                        "\"email\":\"jane.doe@example.org\",\"regdate\":[1970,1,1]}"));
    }
}
