package com.benderbrewery.domain.model.exception;

public class EmptyFieldException extends RuntimeException {

    private static final String MSG = "Todos los campos son obligatorios.";

    private EmptyFieldException(String msg) {
        super(msg);
    }

    public static EmptyFieldException thrown() {
        throw new EmptyFieldException(MSG);
    }
}
