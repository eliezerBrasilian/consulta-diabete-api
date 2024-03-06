package com.consultadiabeteapi.diabete.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "result_tb")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "sympthon_id")
    Long sympthonId;

    @Column(name = "type")
    String type;

    public Result(){}
    public Result(Long sympthonId, String type){
        this.sympthonId = sympthonId;
        this.type = type;
    }
    public Long getId(){
        return this.id;
    }
}
