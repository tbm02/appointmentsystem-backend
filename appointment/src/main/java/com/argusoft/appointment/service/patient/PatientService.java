package com.argusoft.appointment.service.patient;


import java.util.List;

import com.argusoft.appointment.entity.Patient;
import com.argusoft.appointment.entity.User;
import com.argusoft.appointment.utils.responsebody.UnAuthenticatedException;

public interface PatientService {
    public Patient addPatient(Patient patient);
    public List<Patient> getAllPatientsByUserId(int userId);
    public List<Patient> getAllPatients();
    public Patient getPatientById(int id);
    public Patient updatePatientById(int id,Patient patient);
    public Patient deletePatientById(int id);
    

 
    
}
