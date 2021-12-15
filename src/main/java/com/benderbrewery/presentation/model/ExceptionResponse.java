package com.benderbrewery.presentation.model;

import java.sql.Timestamp;
import java.util.Date;

public class ExceptionResponse {

    private String exceptionMessage;
    private Timestamp timestamp;

    public ExceptionResponse(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public static ExceptionResponse fromException(String exceptionMessage){
        return new ExceptionResponse(exceptionMessage);
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
