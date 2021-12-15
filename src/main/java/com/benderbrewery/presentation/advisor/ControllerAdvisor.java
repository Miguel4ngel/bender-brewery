package com.benderbrewery.presentation.advisor;

import com.benderbrewery.domain.model.BeerDto;
import com.benderbrewery.domain.model.exception.BeerAlreadyExistsException;
import com.benderbrewery.domain.model.exception.BeerNotFoundException;
import com.benderbrewery.domain.model.exception.EmptyFieldException;
import com.benderbrewery.presentation.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(BeerNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleBeerNotFoundException(
            BeerNotFoundException ex) {
        return new ResponseEntity<>(ExceptionResponse.fromException(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyFieldException.class)
    public ResponseEntity<ExceptionResponse> handleEmptyFieldException(
            EmptyFieldException ex) {
        return new ResponseEntity<>(ExceptionResponse.fromException(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BeerAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleBeerAlreadyExistsException(
            BeerAlreadyExistsException ex) {
        return new ResponseEntity<>(ExceptionResponse.fromException(ex.getMessage()), HttpStatus.CONFLICT);
    }


}
