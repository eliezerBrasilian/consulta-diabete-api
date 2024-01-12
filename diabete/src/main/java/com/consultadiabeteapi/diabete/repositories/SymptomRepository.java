package com.consultadiabeteapi.diabete.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consultadiabeteapi.diabete.models.Symptom;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom,Long> {} 
