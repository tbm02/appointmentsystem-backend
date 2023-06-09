package com.argusoft.appointment.dao.doctor;

import java.util.List;
import java.util.Map;

import com.argusoft.appointment.entity.Doctor;

public interface DoctorDao {

    public Doctor addDoctor(Doctor doctor) ;
    public List<Doctor> getDoctors();
    public Doctor getDoctorById(int id);
    public Doctor updateDoctorById(int id,Doctor updatedDoctor);
    public Doctor deleteDoctorById(int id);  
    public <T> List<Doctor> getDoctorByParam(String paramName,T paramValue); 
    public  List<Doctor> getDoctorByQueryParam(Map<String,String> queires); 

}
