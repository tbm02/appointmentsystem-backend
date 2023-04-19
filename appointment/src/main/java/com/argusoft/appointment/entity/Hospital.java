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
public class Hospital implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {

        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

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

   
    @OneToMany(mappedBy = "hospital")
    @JsonIgnore
    List<Doctor> doctors;

    @Column(name = "hospitalAdminEmail")
    @NotBlank(message = "Please Provide the doctors email as it can not be left emptty")
    @Pattern(regexp = "[a-z]+([0-9]*)[@][a-z]+[.][a-z]{2,3}", message = "Please Provide the valid email")
    private String email;

    @Column(name = "hospitalAdminPassword")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Password must contain atleast one capital charchter, one small character, one digit and one special character and minimum length is 8")
    private String password;

    @Column(name = "hospitalAdminContactNo")
    @Pattern(regexp = "([+][1-9]{2,3})?([2-9]{1}[0-9]{5}|[789]{1}[0-9]{9})", message = "Please Provide the valid Contact No")
    private String hospitalAdminContactNo;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setHospitalAdminpassword(String hospitalAdminPassword) {
        this.password = hospitalAdminPassword;
    }

    public String getHospitalAdminContactNo() {
        return hospitalAdminContactNo;
    }

    public void setHospitalAdminContactNo(String hospitalAdminContactNo) {
        this.hospitalAdminContactNo = hospitalAdminContactNo;
    }

    public String getHospitalName() {
        return hospitalName;
        }
    
        public void setHospitalAdminassword(String hospitalAdminassword) {
            this.password = hospitalAdminassword;
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
                + hospitalAddress + ", hospitalContactNo=" +hospitalAdminContactNo + "hospitalEmail = "+email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
