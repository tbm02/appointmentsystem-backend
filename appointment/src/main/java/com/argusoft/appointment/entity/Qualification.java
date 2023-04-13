package com.argusoft.appointment.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Qualification")
public class Qualification {

    @Id
    @Column(name = "qualificationId")
    private int qualificationId;


    @Column(name = "qualificationName")
    private String qualificationName;

    @ManyToMany(mappedBy = "qualifications")
    private Set<Doctor> doctors;
    
    public int getQualificationId() {
        return qualificationId;
    }


    public void setQualificationId(int qualificationId) {
        this.qualificationId = qualificationId;
    }


    public String getQualificationName() {
        return qualificationName;
    }


    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
    }


    @Override
    public String toString() {
        return "Qualification [qualificationId=" + qualificationId + ", qualificationName=" + qualificationName + "]";
    }


    public Set<Doctor> getDoctors() {
        return doctors;
    }


    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }


   
    

    
    
}
