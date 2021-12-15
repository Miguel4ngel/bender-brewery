package com.benderbrewery.domain.model.exception;

public class BeerNotFoundException extends RuntimeException{

    private static final String MSG = "El Id de la cerveza no existe";

    private BeerNotFoundException(String msg) {
        super(msg);
    }

    public static BeerNotFoundException thrown() {
        throw new BeerNotFoundException(MSG);
    }
}
