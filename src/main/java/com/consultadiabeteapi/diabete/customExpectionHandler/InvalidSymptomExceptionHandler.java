package com.consultadiabeteapi.diabete.customExpectionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.consultadiabeteapi.diabete.exceptions.InvalidSymptomException;

@ControllerAdvice
public class InvalidSymptomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidSymptomException.class)
    public ResponseEntity<Object> handleSintomaInvalidoException(InvalidSymptomException ex) {
        String mensagemErro = ex.getMessage();
        return new ResponseEntity<>(mensagemErro, HttpStatus.BAD_REQUEST);
    }
}
