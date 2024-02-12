package com.consultadiabeteapi.diabete.exceptions;

public class InsuficientAmountOfSymtoms extends RuntimeException {
    public InsuficientAmountOfSymtoms(int amount){
        super("Quantidade de sintomas menor do que o minimo esperado: " + amount);
    }
   
}
