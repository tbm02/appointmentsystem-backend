package com.argusoft.appointment.dao.diagnosis;

import java.util.List;

import com.argusoft.appointment.entity.Diagnosis;

public interface DiagnosisDao {
    public Diagnosis addDiagnosis(Diagnosis diagnosis) ;
    public List<Diagnosis> getDiagnosiss();
    public Diagnosis getDiagnosisById(int id);
    public Diagnosis updateDiagnosisById(int id,Diagnosis updatedDiagnosis);
    public Diagnosis deleteDiagnosisById(int id);  
    public List<Diagnosis> getDiagnosisByParam(String paramName,String paramValue);
}
