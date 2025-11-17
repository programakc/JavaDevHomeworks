package ru.klgd.javadev.attestation03.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserResponse(
        String nickname,
        String fio,
        Integer age,
        String email,
        LocalDate regdate
) {
}
