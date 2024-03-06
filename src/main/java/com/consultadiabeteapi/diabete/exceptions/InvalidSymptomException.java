package com.consultadiabeteapi.diabete.exceptions;

public class InvalidSymptomException extends RuntimeException {
    public InvalidSymptomException(String sintoma) {
        super("Sintoma inválido: " + sintoma);
    }
}
