package com.argusoft.appointment.service.disease;

import java.util.List;

import com.argusoft.appointment.entity.Disease;
import com.argusoft.appointment.utils.responsebody.UnAuthenticatedException;

public interface DiseaseService {
    public Disease addDisease(Disease disease);
    public List<Disease> getAllDiseases();
    public Disease getDiseaseById(int id);
    public Disease updateDiseaseById(int id,Disease disease);
    public Disease deleteDiseaseById(int id);
}
