package com.benderbrewery.data.connector.currency.exception;

public class CurrencyNotFoundException extends RuntimeException{

    private static final String MSG = "No existe ninguna moneda para el codigo enviado.";

    private CurrencyNotFoundException(String msg) {
        super(msg);
    }

    public static CurrencyNotFoundException thrown() {
        throw new CurrencyNotFoundException(MSG);
    }

}
