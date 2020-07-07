/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author acer
 */
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private Double BMI;
    private Double Glucose;
    private Double Insulin;
    private Double HOMA;
    private Double Leptin;
    private Double Adiponectin;
    private Double Resistin;
    private Double MCP;
    private String state; 
    private Doctor doc;

    public Doctor getDoc() {
        return doc;
    }

    public void setDoc(Doctor doc) {
        this.doc = doc;
    }
    
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getBMI() {
        return BMI;
    }

    public void setBMI(Double BMI) {
        this.BMI = BMI;
    }

    public Double getGlucose() {
        return Glucose;
    }

    public void setGlucose(Double Glucose) {
        this.Glucose = Glucose;
    }

    public Double getInsulin() {
        return Insulin;
    }

    public void setInsulin(Double Insulin) {
        this.Insulin = Insulin;
    }

    public Double getHOMA() {
        return HOMA;
    }

    public void setHOMA(Double HOMA) {
        this.HOMA = HOMA;
    }

    public Double getLeptin() {
        return Leptin;
    }

    public void setLeptin(Double Leptin) {
        this.Leptin = Leptin;
    }

    public Double getAdiponectin() {
        return Adiponectin;
    }

    public void setAdiponectin(Double Adiponectin) {
        this.Adiponectin = Adiponectin;
    }

    public Double getResistin() {
        return Resistin;
    }

    public void setResistin(Double Resistin) {
        this.Resistin = Resistin;
    }

    public Double getMCP() {
        return MCP;
    }

    public void setMCP(Double MCP) {
        this.MCP = MCP;
    }
    
}
