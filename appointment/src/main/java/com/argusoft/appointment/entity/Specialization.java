package com.argusoft.appointment.entity;

import java.util.Set;

import com.argusoft.appointment.utils.customserializers.DoctorSpecializationSerializer;
import com.argusoft.appointment.utils.customserializers.SpecializationDoctorSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Specialization")
// @JsonSerialize(using = DoctorSpecializationSerializer.class)
public class Specialization {

    @Id
    @Column(name = "specializationId")
    private int specializationId;


    @Column(name = "specializationName")
    private String specializationName;

    @ManyToMany(mappedBy = "specializations")
    // @JsonIgnore
    @JsonSerialize(using = SpecializationDoctorSerializer.class)
    private Set<Doctor> doctors;
    
    public int getSpecializationId() {
        return specializationId;
    }


    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }


    public String getSpecializationName() {
        return specializationName;
    }


    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }


    @Override
    public String toString() {
        return "Specialization [specializationId=" + specializationId + ", specializationName=" + specializationName + "]";
    }


    public Set<Doctor> getDoctors() {
        return doctors;
    }


    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }


   
    

    
    
}
