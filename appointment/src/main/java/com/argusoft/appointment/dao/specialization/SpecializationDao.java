package com.argusoft.appointment.dao.specialization;

import java.util.List;

import com.argusoft.appointment.entity.Specialization;

public interface SpecializationDao {
    public Specialization addSpecialization(Specialization specialization);
    public List<Specialization> getSpecializations();
    public Specialization getSpecializationById(int id);
    public Specialization updateSpecializationById(int id,Specialization updatedSpecialization);
    public Specialization deleteSpecializationById(int id);  
    public List<Specialization> getSpecializationByParam(String paramName,String paramValue); 
}
