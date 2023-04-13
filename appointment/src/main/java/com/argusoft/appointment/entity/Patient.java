package com.argusoft.appointment.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Patient")
public class Patient {
    @Id
    @Column(name = "patientId")
    private int patientId;

    @Column(name = "patientFirstName")
    private String patientFirstName;

    @Column(name = "patientLastName")
    private String patientLastName;

    @Column(name = "patientContactNo")
    @Pattern(regexp = "([+][1-9]{2,3})?([2-9]{1}[0-9]{5}|[789]{1}[0-9]{9})", message = "Please Provide the valid Contact No")
    private String patientContactNo;

    @NotBlank(message = "Please Provide the Patient email as it can not be left emptty")
    @Pattern(regexp = "[a-z]+([0-9]*)[@][a-z]+[.][a-z]{2,3}", message = "Please Provide the valid email")
    @Column(name = "patientEmail")
    private String patientEmail;

    @ManyToOne
    @JoinColumn(name = "consumerId")
    private Consumer consumer;

    @Column(name = "dob")
    private java.sql.Date dob;

    @ManyToMany
    @JoinTable(name = "PatientDiseaseMap", joinColumns = @JoinColumn(name = "patientId"), inverseJoinColumns = @JoinColumn(name = "diseaseId"))
    private Set<Disease> diseases;

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

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
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
                + patientLastName + ", dob=" + dob + "]";
    }

    public Patient() {
        // System.out.println("Patient:Creating a patient Object");
    }

    public String getPatientContactNo() {
        return patientContactNo;
    }

    public void setPatientContactNo(String patientContactNo) {
        this.patientContactNo = patientContactNo;
    }

}
