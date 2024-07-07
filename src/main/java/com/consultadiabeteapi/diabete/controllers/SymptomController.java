package com.consultadiabeteapi.diabete.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultadiabeteapi.diabete.exceptions.InsuficientAmountOfSymtoms;
import com.consultadiabeteapi.diabete.exceptions.InvalidSymptomException;
import com.consultadiabeteapi.diabete.records.ResultSympthomRecord;
import com.consultadiabeteapi.diabete.services.SymptomService;

@RestController
@RequestMapping("api/symptoms/v1")
public class SymptomController {
    @Autowired
    SymptomService symptomService;

    @GetMapping()
    public String getMethodName() {
        return "<h1>Oi</h1>";
    }
    
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping()
    public ResultSympthomRecord saveSympthoms(@RequestBody List<String> symptoms) {
        return symptomService.saveSymptom(symptoms);
    }
    
}
