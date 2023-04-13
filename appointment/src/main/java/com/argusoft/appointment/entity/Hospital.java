package com.argusoft.appointment.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

   
    @OneToMany(mappedBy = "hospital")
    @JsonIgnore
    List<Doctor> doctors;

    @Column(name = "hospitalAdminEmail")
    @NotBlank(message = "Please Provide the doctors email as it can not be left emptty")
    @Pattern(regexp = "[a-z]+([0-9]*)[@][a-z]+[.][a-z]{2,3}", message = "Please Provide the valid email")
    private String hospitalAdminEmail;

    @Column(name = "hospitalAdminassword")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Password must contain atleast one capital charchter, one small character, one digit and one special character and minimum length is 8")
    private String hospitalAdminassword;

    @Column(name = "hospiatlAdminContactNo")
    @Pattern(regexp = "([+][1-9]{2,3})?([2-9]{1}[0-9]{5}|[789]{1}[0-9]{9})", message = "Please Provide the valid Contact No")
    private String hospiatlAdminContactNo;
    public List<Doctor> getDoctors() {
        return doctors;
    }


    @OneToOne
    @JoinColumn(name = "roleId")
    private Role role;
    

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalAdminEmail() {
        return hospitalAdminEmail;
    }

    public void setHospitalAdminEmail(String hospitalAdminEmail) {
        this.hospitalAdminEmail = hospitalAdminEmail;
    }

    public String getHospitalAdminassword() {
        return hospitalAdminassword;
    }

    public void setHospitalAdminassword(String hospitalAdminassword) {
        this.hospitalAdminassword = hospitalAdminassword;
    }

    public String getHospiatlAdminContactNo() {
        return hospiatlAdminContactNo;
    }

    public void setHospiatlAdminContactNo(String hospiatlAdminContactNo) {
        this.hospiatlAdminContactNo = hospiatlAdminContactNo;
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

    
    @Override
    public String toString() {
        return "Hospital [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", hospitalAddress="
                + hospitalAddress + ", hospitalContactNo=" ;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
