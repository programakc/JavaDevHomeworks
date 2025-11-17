package ru.klgd.javadev.attestation03.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.klgd.javadev.attestation03.dto.UserRequest;
import ru.klgd.javadev.attestation03.dto.UserResponse;
import ru.klgd.javadev.attestation03.entities.User;

import java.time.LocalDate;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {LocalDate.class})
public interface UserMapper {

    UserResponse toUserResponse(User user);

    @Mapping(target = "regdate", expression = "java(LocalDate.now())")
    @Mapping(target = "isDeleted", defaultValue = "false")
    User fromUserCreateRequest(UserRequest userRequest);

}
