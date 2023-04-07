package com.argusoft.appointment.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="Users",uniqueConstraints = @UniqueConstraint(columnNames = {"contactNo","email"}))
public class User {

    @Id
    @Column(name = "userId")
    private int id;

    @Column(name = "firstName",nullable = false)
    
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name = "contactNo",nullable = false)
    private String contactNo;

    @Column(name="email")
    private String email;

    @Column(name="address")
    private String address;

    @Column(name="dob")
    private java.sql.Date dob;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Patient> patients;


    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.sql.Date getDob() {
        return dob;
    }

    public void setDob(java.sql.Date dob) {
        this.dob = dob;
    }

    public User(){
        System.out.println("Empty Constructor is called for the bean initalisation" );
    }

    public User(String firstName,String lastName,String contactNo,String email,String address,String password){
        this.firstName = firstName;
        this.email = email;
        this.contactNo = contactNo;
        this.password = password;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
                + ", contactNo=" + contactNo + ", email=" + email + ", address=" + address + ", dob=" + dob + "]";
    }
    
    
}
