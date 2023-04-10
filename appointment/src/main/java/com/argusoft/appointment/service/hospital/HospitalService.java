package com.argusoft.appointment.service.hospital;

import java.util.List;

import com.argusoft.appointment.entity.Hospital;
import com.argusoft.appointment.utils.customexceptions.UnAuthenticatedException;

public interface HospitalService {
    public Hospital signUpHospital(Hospital hospital);
    public Hospital authenticateHospital(String email,String password) throws UnAuthenticatedException;
    public List<Hospital> getAllHospitals();
    public Hospital getHospitalById(int id);
    public Hospital updateHospitalById(int id,Hospital hospital);
    public Hospital deleteHospitalById(int id);
    
}
