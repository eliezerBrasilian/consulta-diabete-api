package com.consultadiabeteapi.diabete.services.impl;

import com.consultadiabeteapi.diabete.exceptions.InsuficientAmountOfSymtoms;
import com.consultadiabeteapi.diabete.exceptions.InvalidSymptomException;
import com.consultadiabeteapi.diabete.models.Result;
import com.consultadiabeteapi.diabete.models.Symptom;
import com.consultadiabeteapi.diabete.records.ResultSympthomRecord;
import com.consultadiabeteapi.diabete.repositories.ResultRepository;
import com.consultadiabeteapi.diabete.repositories.SymptomRepository;
import com.consultadiabeteapi.diabete.services.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomServiceImpl implements SymptomService {
    @Autowired
    SymptomRepository symptomRepository;

    @Autowired
    ResultRepository resultRepository;

    @Override
    public ResultSympthomRecord saveSymptom(List<String> symptoms){

        String concatenedSympthoms = getConcatenedSympthoms(symptoms);

        Symptom entity = new Symptom(concatenedSympthoms);
        symptomRepository.save(entity);
        Long sympthonId = entity.getId();

        String type = getDiabetesType(symptoms);

        Result resultEntity = new Result(sympthonId,type);
        resultRepository.save(resultEntity);
        return new ResultSympthomRecord(resultEntity.getId(), type);
    }

    private  String getDiabetesType(List<String> symptoms) {
        boolean hasDormency = symptoms.contains("Formigamento/dormência");
        boolean hasFrequentInfection = symptoms.contains("Infecções frequentes (epiteliais e vaginais)");
        boolean hasFormationOfStains = symptoms.contains("Formação de manchas escuras na pele");

        String type = (hasDormency || hasFrequentInfection || hasFormationOfStains)? "tipo 2" : "tipo 1";
        return type;
    }

    private  String getConcatenedSympthoms(List<String> symptoms) {
        var baseSyntoms = List.of(
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
        return concatenedSympthoms;
    }
}