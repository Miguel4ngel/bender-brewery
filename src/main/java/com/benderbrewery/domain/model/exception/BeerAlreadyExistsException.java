package com.benderbrewery.domain.model.exception;

public class BeerAlreadyExistsException extends RuntimeException {

    private static final String MSG = "El ID Ingresado ya existe.";

    private BeerAlreadyExistsException(String msg) {
        super(msg);
    }

    public static BeerAlreadyExistsException thrown() {
        throw new BeerAlreadyExistsException(MSG);
    }
}
