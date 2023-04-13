package com.argusoft.appointment.entity;

import java.sql.Time;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Doctor")
public class Doctor {

    @Id
    @Column(name = "doctorId")
    private int doctorId;

    @Column(name = "firstName")
    @NotBlank(message = "Please provide doctors name as it can not be empty")
    private String firstName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "lastName")
    @NotBlank(message = "Please provide doctors name as it can not be empty")
    private String lastName;

    @Column(name = "email")
    @NotBlank(message = "Please Provide the doctors email as it can not be left emptty")
    @Pattern(regexp = "[a-z]+([0-9]*)[@][a-z]+[.][a-z]{2,3}", message = "Please Provide the valid email")
    private String email;

    @Column(name = "password")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Password must contain atleast one capital charchter, one small character, one digit and one special character and minimum length is 8")
    private String password;

    @Column(name = "contactNo")
    @Pattern(regexp = "([+][1-9]{2,3})?([2-9]{1}[0-9]{5}|[789]{1}[0-9]{9})", message = "Please Provide the valid Contact No")
    private String contactNo;
   
    @OneToOne
    @JoinColumn(name = "roleId")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "hospitalId")
    private Hospital hospital;

    @ManyToMany
    @JoinTable(name = "DoctorDiseaseMap", joinColumns = @JoinColumn(name = "doctorId"), inverseJoinColumns = @JoinColumn(name = "diseaseId")

    )
    private Set<Disease> diseases;

    @Column(name = "slotDuration")
    private int slotDuration;

    @Column(name = "bufferTime")
    private int bufferTime;

    @Column(name = "startTime")
    private Time startTime;

    @Column(name = "endTime")
    private int endTime;

    @Column(name = "recessStartTime")
    private int recessStartTime;

    @Column(name = "recessEndTime")
    private int recessEndTime;

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

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getRecessStartTime() {
        return recessStartTime;
    }

    public void setRecessStartTime(int recessStartTime) {
        this.recessStartTime = recessStartTime;
    }

    public int getRecessEndTime() {
        return recessEndTime;
    }

    public void setRecessEndTime(int recessEndTime) {
        this.recessEndTime = recessEndTime;
    }

    @ManyToMany
    @JoinTable(name = "DoctorQualificationMap", joinColumns = @JoinColumn(name = "doctorId"), inverseJoinColumns = @JoinColumn(name = "qualificationId"))
    private Set<Qualification> qualifications;

    public Set<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(Set<Disease> diseases) {
        this.diseases = diseases;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
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

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    @Override
    public String toString() {
        return "Doctor [doctorId=" + doctorId + ", doctorName=" + firstName + " " + lastName + ", doctorEmail=" + email
                + ", contactNo=" + contactNo + ", hospital=" + hospital + "]";
    }

    public Set<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(Set<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
