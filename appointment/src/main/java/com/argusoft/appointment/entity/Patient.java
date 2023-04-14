package com.argusoft.appointment.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;

    @Column(name = "firstName")
    @NotBlank(message = "Please Prvide first name")
    private String firstName;

    @Column(name = "lastName")
    @NotBlank(message = "Please Prvide last name")
    private String lastName;

    @Column(name = "contactNo")
    @Pattern(regexp = "([+][1-9]{2,3})?([2-9]{1}[0-9]{5}|[789]{1}[0-9]{9})", message = "Please Provide the valid Contact No")
    private String contactNo;

    @NotBlank(message = "Please Provide the Patient email as it can not be left emptty")
    @Pattern(regexp = "[a-z]+([0-9]*)[@][a-z]+[.][a-z]{2,3}", message = "Please Provide the valid email")
    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person;

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

  

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public java.sql.Date getDob() {
        return dob;
    }

    public void setDob(java.sql.Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Patient [patientId=" + patientId + ", patientFirstName=" + firstName + ", patientLastName="
                + lastName + ", dob=" + dob + "]";
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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(Set<Disease> diseases) {
        this.diseases = diseases;
    }

    

   
}
