package com.argusoft.appointment.dao.hospital;

import java.util.List;

import com.argusoft.appointment.entity.Hospital;

public interface HospitalDao {
    public Hospital addHospital(Hospital hospital) ;
    public List<Hospital> getHospitals();
    public Hospital getHospitalById(int id);
    public Hospital updateHospitalById(int id,Hospital updatedHospital);
    public Hospital deleteHospitalById(int id);  
    public List<Hospital> getHospitalByParam(String paramName,String paramValue); 
}
