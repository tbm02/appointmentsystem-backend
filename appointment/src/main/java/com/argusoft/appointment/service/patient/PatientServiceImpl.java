package com.argusoft.appointment.service.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.appointment.dao.patient.PatientDao;
import com.argusoft.appointment.entity.Patient;
import com.argusoft.appointment.utils.customannotations.LogThis;

import jakarta.transaction.Transactional;


@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    @LogThis
    @Override
    @Transactional

    public Patient addPatient(Patient patient) {
        return patientDao.addPatient(patient);
    }
    @LogThis
    @Override
    @Transactional
    public Patient deletePatientById(int id) {
        return patientDao.deletePatientById(id);
    }


    @LogThis
    @Override
    @Transactional
    public List<Patient> getAllPatients() {
        return patientDao.getPatients();
    }


    @LogThis
    @Override
    @Transactional
    public List<Patient> getAllPatientsByPersonId(int personId) {
        return patientDao.getPatientByParam("personId", String.valueOf(personId));
    }


    @LogThis
    @Override
    @Transactional
    public Patient getPatientById(int id) {
        return patientDao.getPatientById(id);
    }


    @LogThis
    @Override
    @Transactional
    public Patient updatePatientById(int id, Patient patient) {
        return patientDao.updatePatientById(id, patient);
    }
    
}
