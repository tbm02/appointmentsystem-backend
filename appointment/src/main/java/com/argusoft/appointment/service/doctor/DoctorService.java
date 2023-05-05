package com.argusoft.appointment.service.doctor;

import java.util.List;
import java.util.Map;

import com.argusoft.appointment.entity.Doctor;
import com.argusoft.appointment.utils.customexceptions.UnAuthenticatedException;

public interface DoctorService {
    public Doctor signUpDoctor(Doctor doctor);
    public Doctor authenticateDoctor(String email,String password) throws UnAuthenticatedException;
    public List<Doctor> getAllDoctors();
    public Doctor getDoctorById(int id);
    public Doctor updateDoctorById(int id,Doctor doctor);
    public Doctor deleteDoctorById(int id);
    public List<Doctor> getAllDoctorsByHospital(int hospitalId);
    public List<Doctor> getDoctorsByQueryParams(Map<String,String> queries);
}
