package com.argusoft.appointment.dao.disease;

import java.util.List;

import com.argusoft.appointment.entity.Disease;

public interface DiseaseDao {
    public Disease addDisease(Disease disease) ;
    public List<Disease> getDiseases();
    public Disease getDiseaseById(int id);
    public Disease updateDiseaseById(int id,Disease updatedDisease);
    public Disease deleteDiseaseById(int id);  
    public List<Disease> getDiseaseByParam(String paramName,String paramValue); 
}
