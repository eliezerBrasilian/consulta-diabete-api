package com.consultadiabeteapi.diabete.services;


import com.consultadiabeteapi.diabete.exceptions.InsuficientAmountOfSymtoms;
import com.consultadiabeteapi.diabete.exceptions.InvalidSymptomException;
import com.consultadiabeteapi.diabete.records.ResultSympthomRecord;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SymptomService {
    ResultSympthomRecord saveSymptom(List<String> symptoms)
            throws InsuficientAmountOfSymtoms, InvalidSymptomException;
}
