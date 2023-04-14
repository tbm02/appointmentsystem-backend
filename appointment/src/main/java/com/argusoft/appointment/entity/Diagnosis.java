package com.argusoft.appointment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "Diagnosis")
public class Diagnosis {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "diseaseId")
    private Disease disease;


    @Column(name = "remark")
    private String remarks;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public Doctor getDoctor() {
        return doctor;
    }


    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


    public Patient getPatient() {
        return patient;
    }


    public void setPatient(Patient patient) {
        this.patient = patient;
    }


    public Disease getDisease() {
        return disease;
    }


    public void setDisease(Disease disease) {
        this.disease = disease;
    }


    public String getRemarks() {
        return remarks;
    }
    

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    


}
