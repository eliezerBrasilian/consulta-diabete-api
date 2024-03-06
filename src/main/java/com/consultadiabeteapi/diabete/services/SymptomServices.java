package com.consultadiabeteapi.diabete.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultadiabeteapi.diabete.models.Result;
import com.consultadiabeteapi.diabete.models.Symptom;
import com.consultadiabeteapi.diabete.records.ResultSympthomRecord;
import com.consultadiabeteapi.diabete.repositories.ResultRepository;
import com.consultadiabeteapi.diabete.repositories.SymptomRepository;

@Service
public class SymptomServices {
    @Autowired
    SymptomRepository symptomRepository;

    @Autowired
    ResultRepository resultRepository;

    public ResultSympthomRecord saveSymptom(String symptoms){
        Symptom entity = new Symptom(symptoms);
        symptomRepository.save(entity);
        Long sympthonId = entity.getId();
        //Infecções frequentes (epiteliais e vaginais)
        //Formação de manchas escuras na pele
        //Formigamento/dormência
        boolean hasDormency = symptoms.contains("Formigamento/dormência");
        boolean hasFrequentInfection = symptoms.contains("Infecções frequentes (epiteliais e vaginais)");
        boolean hasFormationOfStains = symptoms.contains("Formação de manchas escuras na pele");
       
        String type = (hasDormency || hasFrequentInfection || hasFormationOfStains)? "tipo 2" : "tipo 1"; 
        
        Result resultEntity = new Result(sympthonId,type);
        resultRepository.save(resultEntity);
        return new ResultSympthomRecord(resultEntity.getId(), type);
    }
}
