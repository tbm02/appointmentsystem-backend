package com.argusoft.appointment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Doctor")
public class Doctor {
    @Id
    @Column(name = "doctorId")
    private int doctorId;


    @Column(name = "doctorName")
    private String doctorName;


    @Column(name = "doctorEmail")
    private String doctorEmail;

    @Column(name = "password")
    private String password;


    @Column(name = "contactNo")
    private String contactNo;


    @ManyToOne
    @JoinColumn(name = "hospitalId")
    private Hospital hospital;

    @Column(name = "noOfSlots")
    private int noOfSlots;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public int getNoOfSlots() {
        return noOfSlots;
    }

    public void setNoOfSlots(int noOfSlots) {
        this.noOfSlots = noOfSlots;
    }

    @Override
    public String toString() {
        return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorEmail=" + doctorEmail
                + ", contactNo=" + contactNo + ", hospital=" + hospital + ", noOfSlots=" + noOfSlots + "]";
    }

    

}
