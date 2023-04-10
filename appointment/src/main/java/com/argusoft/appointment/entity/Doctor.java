package com.argusoft.appointment.entity;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Env;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="Doctor")
@PropertySources({
    @PropertySource("classpath:application.properties"),
    @PropertySource("classpath:regex.properties")
})
public class Doctor {
    // @Autowired
    // private Environment env;
    @Id
    @Column(name = "doctorId")
    private int doctorId;


    @Column(name = "doctorName")
    @NotBlank(message = "Please provide doctors name as it can not be empty")
    private String doctorName;


    @Column(name = "doctorEmail")
    @NotBlank(message = "Please Provide the doctors email as it can not be left emptty")
    @Pattern(regexp = "[a-z]+([0-9]*)[@][a-z]+[.][a-z]{2,3}", message = "Please Provide the valid email")
    private String doctorEmail;

    @Column(name = "password")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",
    message = "Password must contain atleast one capital charchter, one small character, one digit and one special character and minimum length is 8")
    private String password;


    @Column(name = "contactNo")
    @Pattern(regexp = "([+][1-9]{2,3})?([2-9]{1}[0-9]{5}|[789]{1}[0-9]{9})", message = "Please Provide the valid Contact No")
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

    public Doctor(){
       
    }
    

}
