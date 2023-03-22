package com.argusoft.appointment.service.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.appointment.dao.patient.PatientDao;
import com.argusoft.appointment.entity.Patient;
import com.argusoft.appointment.utils.customannotations.LogThis;


@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    @LogThis
    @Override
    public Patient addPatient(Patient patient) {
        return patientDao.addPatient(patient);
    }
    @LogThis
    @Override
    public Patient deletePatientById(int id) {
        return patientDao.deletePatientById(id);
    }


    @LogThis
    @Override
    public List<Patient> getAllPatients() {
        return patientDao.getPatients();
    }


    @LogThis
    @Override
    public List<Patient> getAllPatientsByUserId(int userId) {
        return patientDao.getPatientByParam("userId", String.valueOf(userId));
    }


    @LogThis
    @Override
    public Patient getPatientById(int id) {
        return null;
    }


    @LogThis
    @Override
    public Patient updatePatientById(int id, Patient patient) {
        return null;
    }
    
}
