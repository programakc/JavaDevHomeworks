package ru.klgd.javadev.attestation03.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserRequest(
        Long id,
        String nickname,
        String password,
        String fio,
        Integer age,
        String email,
        LocalDate regdate,
        Boolean isDeleted
) {
}
