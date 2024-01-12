package com.consultadiabeteapi.diabete.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.consultadiabeteapi.diabete.records.ResultSympthomRecord;
import com.consultadiabeteapi.diabete.services.SymptomServices;

@RestController
public class SymptomController {
    @Autowired
    SymptomServices symptomServices;

    @GetMapping("/")
    public String getMethodName() {
        return "<h1>Oi</h1>";
    }
    
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/symptoms")
    public ResultSympthomRecord saveSympthoms(@RequestBody List<String> symptoms) {
        String concatenedSympthoms = String.join(",", symptoms);
        ResultSympthomRecord result = symptomServices.saveSymptom(concatenedSympthoms);
        return result;
    }
    
}
