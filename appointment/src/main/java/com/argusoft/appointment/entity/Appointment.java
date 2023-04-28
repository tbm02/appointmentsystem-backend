package com.argusoft.appointment.entity;

import java.sql.Date;
import java.sql.Time;

import com.argusoft.appointment.utils.customserializers.AppointmentDoctorSerializer;
import com.argusoft.appointment.utils.customserializers.AppointmentPatientSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "AppointmentTable")
public class Appointment {

    @Id
    @Column(name = "appointmentId")
    private int appointmentId;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    // @JsonSerialize(using = )
    @JsonSerialize(using = AppointmentDoctorSerializer.class)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patientId")
    @JsonSerialize(using = AppointmentPatientSerializer.class)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "diseaseId")
    private Disease disease;

    @Column(name = "appointmentTime")
    private Time appointmentTime;

    @Column(name = "appointmentDate")
    private Date appointmentDate;

    @Column(name = "status")
    private String status = "Pending";

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Time getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Time appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
