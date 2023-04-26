package com.argusoft.appointment.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.argusoft.appointment.utils.customserializers.PersonPatientSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.CascadeType;
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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Person")
public class Person {


    @Id
    @Column(name = "personId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    @Column(name = "firstName")
    @NotBlank(message = "Please provide person first name as it can not be empty")
    private String firstName;

    @Column(name = "lastName")
    @NotBlank(message = "Please provide person last name as it can not be empty")
    private String lastName;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "dob")
    @NotNull(message = "Please Provide the Date of birth")
    private Date dob;

    @Column(name = "address")
    @NotBlank(message = "Please provide person address as it can not be empty")
    private String address;

    @OneToMany(mappedBy = "person", cascade = { CascadeType.ALL })
    @JsonSerialize(using = PersonPatientSerializer.class)
    private Set<Patient> patients;

    public Person(int personId, String firstName, String lastName, User user, Date dob, String address, Set<Patient> patients) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.user = user;
        this.dob = dob;
        this.address = address;
        this.patients = patients;
    }

    public Person() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", user=" + user
                + ", dob=" + dob + ", address=" + address + "]";
    }





}
