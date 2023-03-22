package com.argusoft.appointment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Disease {
    @Id
    @Column(name = "diseaseId")
    private int diseaseId;

    @Column(name = "diseaseName")
    private String diseaseName;

    public int getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(int diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public Disease(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    @Override
    public String toString() {
        return "Disease [diseaseId=" + diseaseId + ", diseaseName=" + diseaseName + "]";
    }

    
    
}
