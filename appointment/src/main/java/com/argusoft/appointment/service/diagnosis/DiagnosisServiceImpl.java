package com.argusoft.appointment.service.diagnosis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.appointment.dao.diagnosis.DiagnosisDao;
import com.argusoft.appointment.dao.patient.PatientDao;
import com.argusoft.appointment.entity.Diagnosis;
import com.argusoft.appointment.entity.Patient;
import com.argusoft.appointment.utils.customannotations.LogThis;
import jakarta.transaction.Transactional;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    public DiagnosisServiceImpl() {
        System.out.println("Service Layer Being initalised");
    }

    @Autowired
    private DiagnosisDao diagnosisDao;

    @Autowired
    private PatientDao patientDao;

    @LogThis
    @Override
    @Transactional
    public Diagnosis deleteDiagnosisById(int id) {

        return diagnosisDao.deleteDiagnosisById(id);
    }

    @LogThis
    @Override
    @Transactional
    public List<Diagnosis> getAllDiagnosiss() {

        return diagnosisDao.getDiagnosiss();
    }

    @LogThis
    @Override
    @Transactional
    public Diagnosis getDiagnosisById(int id) {

        return diagnosisDao.getDiagnosisById(id);
    }

    @LogThis
    @Override
    @Transactional
    public Diagnosis addDiagnosis(Diagnosis diagnosis) {

        try{Diagnosis tempDiagnosis = diagnosisDao.addDiagnosis(diagnosis);
        Patient patient = diagnosis.getPatient();
        if (diagnosis.getDisease() != null) {
            patient.getDiseases().add(diagnosis.getDisease());
        }
        patientDao.updatePatientById(patient.getPatientId(), patient);
        return diagnosis;
    
    }
        catch(Exception e){
            e.printStackTrace();
            // return null;
            throw e;    
        }

    }

    @LogThis
    @Override
    @Transactional
    public Diagnosis updateDiagnosisById(int id, Diagnosis diagnosis) {

        return diagnosisDao.updateDiagnosisById(id, diagnosis);
    }
}
