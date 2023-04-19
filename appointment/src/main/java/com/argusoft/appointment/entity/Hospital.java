package com.argusoft.appointment.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "Hospital")
public class Hospital {


    @Id
    @Column(name = "hospitalId")
    @GeneratedValue(strategy = GenerationType.IDENTITY  )
    private int hospitalId;

    @Column(name = "hospitalName")
    @NotBlank(message = "Please Provide the valid hospiatl email as it can not be empty")
    @Pattern(regexp = "([a-zA-Z]{5,})",message = "Please Provide the valid name min length is 5")
    private String hospitalName;

    @Column(name = "hospitalAddress")
    @NotBlank(message = "Please Provide the valid hospiatl Address as it can not be empty")
    private String hospitalAddress;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

   
    @OneToMany(mappedBy = "hospital")
    @JsonIgnore
    List<Doctor> doctors;

    public Hospital(int hospitalId, String hospitalName, String hospitalAddress, User user, List<Doctor> doctors) {
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
        this.hospitalAddress = hospitalAddress;
        this.user = user;
        this.doctors = doctors;
    }

    public Hospital() {
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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


    

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }




}
