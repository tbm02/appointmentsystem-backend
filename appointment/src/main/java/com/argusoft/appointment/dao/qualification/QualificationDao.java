package com.argusoft.appointment.dao.qualification;

import java.util.List;

import com.argusoft.appointment.entity.Qualification;

public interface QualificationDao {
    public Qualification addQualification(Qualification qualification);
    public List<Qualification> getQualifications();
    public Qualification getQualificationById(int id);
    public Qualification updateQualificationById(int id,Qualification updatedQualification);
    public Qualification deleteQualificationById(int id);  
    public List<Qualification> getQualificationByParam(String paramName,String paramValue); 
}
