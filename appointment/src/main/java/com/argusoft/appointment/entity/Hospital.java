package com.argusoft.appointment.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Hospital")
public class Hospital {

    @Id
    @Column(name = "hospitalId")
    private int hospitalId;

    @Column(name = "hospitalName")
    private String hospitalName;

    @Column(name = "hospitalAddress")
    private String hospitalAddress;

    @Column(name = "hospitalContactNo")
    private String hospitalContactNo;

    @Column(name = "hospitalEmail")
    private String hospitalEmail;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "hospital")
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
