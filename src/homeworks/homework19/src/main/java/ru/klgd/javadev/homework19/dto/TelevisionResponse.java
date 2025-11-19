package ru.klgd.javadev.homework19.dto;

public record TelevisionResponse(
        String company,
        String model,
        Integer release,
        Double price,
        Integer countInStock
) {
}
