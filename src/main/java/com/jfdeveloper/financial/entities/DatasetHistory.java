package com.jfdeveloper.financial.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DatasetHistory {

    // "Source","Target","Weight","typeTrans","fraud"
    @Id
    @GeneratedValue
    private Long id;

    private String source;

    private String target;

    private Double weight;

    private String typeTrans;

    private Integer fraud;

    public DatasetHistory() {
    }

    public DatasetHistory(String source, String target, Double weight, String typeTrans, Integer fraud) {
        this.source = source;
        this.target = target;
        this.weight = weight;
        this.typeTrans = typeTrans;
        this.fraud = fraud;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getTypeTrans() {
        return typeTrans;
    }

    public void setTypeTrans(String typeTrans) {
        this.typeTrans = typeTrans;
    }

    public Integer getFraud() {
        return fraud;
    }

    public void setFraud(Integer fraud) {
        this.fraud = fraud;
    }
}
