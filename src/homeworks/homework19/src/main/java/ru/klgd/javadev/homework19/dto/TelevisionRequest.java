package ru.klgd.javadev.homework19.dto;

public record TelevisionRequest(
        Long id,
        String company,
        String model,
        Integer release,
        Double price,
        Integer countInStock
) {
}
