package com.argusoft.appointment.service.doctor;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.appointment.dao.doctor.DoctorDao;
import com.argusoft.appointment.dao.role.RoleDao;
import com.argusoft.appointment.dao.user.UserDao;
import com.argusoft.appointment.entity.Doctor;
import com.argusoft.appointment.utils.customannotations.LogThis;
import com.argusoft.appointment.utils.customexceptions.UnAuthenticatedException;

import jakarta.transaction.Transactional;

@Service
public class DoctorServiceImpl implements DoctorService{
    
    public DoctorServiceImpl(){
        System.out.println("Service Layer Being initalised");
    }
    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;


    @LogThis
    @Override
    @Transactional
    public Doctor authenticateDoctor( String email,  String password) throws UnAuthenticatedException {

 return null;
    }

    @LogThis
    @Override
    @Transactional
    public Doctor deleteDoctorById(int id) {
       
        return doctorDao.deleteDoctorById(id);
    }

    @LogThis
    @Override
    @Transactional
    public List<Doctor> getAllDoctors() {
       
        return doctorDao.getDoctors();
    }

    @LogThis
    @Override
    @Transactional
    public List<Doctor> getAllDoctorsByHospital(int hospitalId) {
       
        return doctorDao.getDoctorByParam("hospital.hospitalId", hospitalId);
    }

    @LogThis
    @Override
    @Transactional
    public Doctor getDoctorById(int id) {
       
        return doctorDao.getDoctorById(id);
    }


    @LogThis
    @Override
    @Transactional
    public Doctor signUpDoctor(Doctor doctor) {
        doctor.getUser().setRole(roleDao.getRoleByParam("roleName","Doctor").get(0));
        userDao.addUser(doctor.getUser());
        return doctorDao.addDoctor(doctor);
    }


    @LogThis
    @Override
    @Transactional
    public Doctor updateDoctorById(int id,Doctor doctor) {
       
        return doctorDao.updateDoctorById(id, doctor);
    }
    @LogThis
    @Transactional
    @Override
    public List<Doctor> getDoctorsByQueryParams (Map<String,String> queries) {
        return doctorDao.getDoctorByQueryParam(queries);
    }
    
}
