package com.argusoft.appointment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Patient")
public class Patient {
    @Id
    @Column(name = "patientId")
    private int patientId;


    @Column(name = "patientFirstName")
    private String patientFirstName;


    @Column(name = "patientLastName")
    private String patientLastName;

    @Column(name="patientContactNo")
    private String patientContactNo;


    
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name="dob")
    private java.sql.Date dob;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public java.sql.Date getDob() {
        return dob;
    }

    public void setDob(java.sql.Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Patient [patientId=" + patientId + ", patientFirstName=" + patientFirstName + ", patientLastName="
                + patientLastName +  ", dob=" + dob + "]";
    }


    public Patient(){
        System.out.println("Patient:Creating a patient Object");
    }

    public String getPatientContactNo() {
        return patientContactNo;
    }

    public void setPatientContactNo(String patientContactNo) {
        this.patientContactNo = patientContactNo;
    }
    




}
