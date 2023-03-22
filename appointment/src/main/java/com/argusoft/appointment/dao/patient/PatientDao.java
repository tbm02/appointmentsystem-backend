package com.argusoft.appointment.dao.patient;

import java.util.List;

import com.argusoft.appointment.entity.Patient;

public interface PatientDao {
    public Patient addPatient(Patient patient) ;
    public List<Patient> getPatients();
    public Patient getPatientById(int id);
    public Patient updatePatientById(int id,Patient updatedPatient);
    public Patient deletePatientById(int id);  
    public List<Patient> getPatientByParam(String paramName,String paramValue); 

   
}
