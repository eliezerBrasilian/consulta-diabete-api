package com.consultadiabeteapi.diabete.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consultadiabeteapi.diabete.models.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result,Long> {}
