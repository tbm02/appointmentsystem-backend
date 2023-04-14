package com.argusoft.appointment.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Disease")
public class Disease {
    @Id
    @Column(name = "diseaseId")
    // @IdGeneratorType()
    private int diseaseId;

    @Column(name = "diseaseName")
    @NotBlank(message = "Please Provide disease name as it can not be empty")
    private String diseaseName;
    

    @ManyToMany(mappedBy = "diseases")
    @JsonIgnore
    private Set<Doctor> doctors;

    @ManyToMany(mappedBy = "diseases")
    @JsonIgnore
    private Set<Patient> patients;
    
    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

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

    public Disease() {

    }

    @Override
    public String toString() {
        return "Disease [diseaseId=" + diseaseId + ", diseaseName=" + diseaseName + "]";
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

}
