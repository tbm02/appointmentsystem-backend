package com.argusoft.appointment.entity;

import java.sql.Time;

import java.util.Set;

import javax.print.Doc;

import com.argusoft.appointment.utils.customserializers.DoctorSpecializationSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "Doctor")
public class Doctor {

    @Id
    @Column(name = "doctorId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;

    @Column(name = "firstName")
    @NotBlank(message = "Please provide doctors name as it can not be empty")
    private String firstName;

    public Doctor() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "lastName")
    @NotBlank(message = "Please provide doctors name as it can not be empty")
    private String lastName;

    @Column(name = "imageLink")
    private String imageLink = "https://img.freepik.com/free-vector/doctor-character-background_1270-84.jpg?w=2000";

    @ManyToOne
    @JoinColumn(name = "hospitalId")
    private Hospital hospital;


    @Column(name = "slotDuration")
    // @NotBlank(message = "Please Provide the slotdurarion")
    private int slotDuration;

    @Column(name = "bufferTime")
    private int bufferTime;

    @Column(name = "startTime")

    private Time startTime;

    @Column(name = "endTime")
    private Time endTime;

    @Column(name = "recessStartTime")
    private Time recessStartTime;

    @Column(name = "recessEndTime")
    private Time recessEndTime;

    @Column(name = "gender")
    private String gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;


    public int getSlotDuration() {
        return slotDuration;
    }

    public void setSlotDuration(int slotDuration) {
        this.slotDuration = slotDuration;
    }

    public int getBufferTime() {
        return bufferTime;
    }

    public void setBufferTime(int bufferTime) {
        this.bufferTime = bufferTime;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Time getRecessStartTime() {
        return recessStartTime;
    }

    public void setRecessStartTime(Time recessStartTime) {
        this.recessStartTime = recessStartTime;
    }

    public Time getRecessEndTime() {
        return recessEndTime;
    }

    public void setRecessEndTime(Time recessEndTime) {
        this.recessEndTime = recessEndTime;
    }

    @ManyToMany
    @JoinTable(name = "DoctorSpecializationMap", joinColumns = @JoinColumn(name = "doctorId"), inverseJoinColumns = @JoinColumn(name = "specializationId"))
    @JsonSerialize(using = DoctorSpecializationSerializer.class)
    private Set<Specialization> specializations;


    public Doctor(int doctorId, String firstName, String lastName, Hospital hospital, int slotDuration, int bufferTime, Time startTime, Time endTime, Time recessStartTime, Time recessEndTime, String gender, User user, Set<Specialization> specializations) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hospital = hospital;
        this.slotDuration = slotDuration;
        this.bufferTime = bufferTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.recessStartTime = recessStartTime;
        this.recessEndTime = recessEndTime;
        this.gender = gender;
        this.user = user;
        this.specializations = specializations;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    

    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public String toString() {
        return "Doctor [doctorId=" + doctorId + ", firstName=" + firstName + ", lastName=" + lastName + ", imageLink="
                + imageLink + ", hospital=" + hospital + ", slotDuration=" + slotDuration + ", bufferTime=" + bufferTime
                + ", startTime=" + startTime + ", endTime=" + endTime + ", recessStartTime=" + recessStartTime
                + ", recessEndTime=" + recessEndTime + ", gender=" + gender + ", user=" + user + ", specializations="
                + specializations + "]";
    }

}
