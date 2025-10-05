package ru.klgd.javadev.exception;

import java.util.NoSuchElementException;

public class CarNotFoundException extends NoSuchElementException {

    public CarNotFoundException(String message) {
        super(message);
    }
}
