package com.argusoft.appointment.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Hospital")
public class Hospital {

    @Id
    @Column(name = "hospitalId")
    private int hospitalId;

    @Column(name = "hospitalName")
    @NotBlank(message = "Please Provide the valid hospiatl email as it can not be empty")
    @Pattern(regexp = "([a-zA-Z]{5,})",message = "Please Provide the valid name min length is 5")
    private String hospitalName;

    @Column(name = "hospitalAddress")
    private String hospitalAddress;

   
    @Column(name = "hospitalContactNo")
    @Pattern(regexp = "([+][1-9]{2,3})?([2-9]{1}[0-9]{5}|[789]{1}[0-9]{9})", message = "Please Provide the valid Contact No")
    private String hospitalContactNo;

    @NotBlank(message = "Please Provide the Hospital email as it can not be left emptty")
    @Pattern(regexp = "[a-z]+([0-9]*)[@][a-z]+[.][a-z]{2,3}", message = "Please Provide the valid email")
    @Column(name = "hospitalEmail")
    private String hospitalEmail;

    @Column(name = "password")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",
    message = "Password must contain atleast one capital charchter, one small character, one digit and one special character and minimum length is 8")
    private String password;

    @OneToMany(mappedBy = "hospital")
    @JsonIgnore
    List<Doctor> doctors;

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public String getHospitalContactNo() {
        return hospitalContactNo;
    }

    public void setHospitalContactNo(String hospitalContactNo) {
        this.hospitalContactNo = hospitalContactNo;
    }

    public String getHospitalEmail() {
        return hospitalEmail;
    }

    public void setHospitalEmail(String hospitalEmail) {
        this.hospitalEmail = hospitalEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Hospital [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", hospitalAddress="
                + hospitalAddress + ", hospitalContactNo=" + hospitalContactNo + ", hospitalEmail=" + hospitalEmail;
    }

}
