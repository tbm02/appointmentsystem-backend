package com.argusoft.appointment.service.diagnosis;

import java.util.List;

import com.argusoft.appointment.entity.Diagnosis;


public interface DiagnosisService {
    public Diagnosis addDiagnosis(Diagnosis diagnosis);
    public List<Diagnosis> getAllDiagnosiss();
    public Diagnosis getDiagnosisById(int id);
    public Diagnosis updateDiagnosisById(int id,Diagnosis diagnosis);
    public Diagnosis deleteDiagnosisById(int id);
}
