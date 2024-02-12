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
import com.consultadiabeteapi.diabete.services.SymptomServices;

@RestController
@RequestMapping("api/symptoms/v1")
public class SymptomController {
    @Autowired
    SymptomServices symptomServices;

    @GetMapping()
    public String getMethodName() {
        return "<h1>Oi</h1>";
    }
    
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping()
    public ResultSympthomRecord saveSympthoms(@RequestBody List<String> symptoms) {

        List<String> baseSyntoms = List.of(
            "Perda de peso não intencional",
        "Dor de estômago e vômitos",
        "Respiração pesada","Excesso de apetite",
        "Formigamento/dormência","Formação de manchas escuras na pele",
        "Dor de estômago e vômitos",
        "Infecções frequentes (epiteliais e vaginais)",
        "Sede excessiva","Micção frequente","Alteração frequente de humor"
        );

        if(symptoms.size() < 5){
            throw new InsuficientAmountOfSymtoms(symptoms.size());
        } 
         for(String s: symptoms){
            if(!baseSyntoms.contains(s)){
                throw new InvalidSymptomException(s);
            }
        }

        String concatenedSympthoms = String.join(",", symptoms);

        ResultSympthomRecord result = symptomServices.saveSymptom(concatenedSympthoms);
        return result;
    }
    
}
