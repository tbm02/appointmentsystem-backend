package com.argusoft.appointment.service.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.appointment.dao.doctor.DoctorDao;
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


    @LogThis
    @Override
    @Transactional
    public Doctor authenticateDoctor( String email,  String password) throws UnAuthenticatedException {
//         // TODO Auto-generated method stub
        
//         Doctor doctor = doctorDao.getDoctorByParam("email",email).get(0);
//         if(doctor.getPassword().equals(password)){
//             System.out.println("Doctor Found and credentials matched");
//             return doctor;
//         }
//         else{
//         throw new UnAuthenticatedException("Invalide credenyials");
//  }       
 
 return null;
    }

    @LogThis
    @Override
    @Transactional
    public Doctor deleteDoctorById(int id) {
        // TODO Auto-generated method stub
        return doctorDao.deleteDoctorById(id);
    }

    @LogThis
    @Override
    @Transactional
    public List<Doctor> getAllDoctors() {
        // TODO Auto-generated method stub
        return doctorDao.getDoctors();
    }


    @LogThis
    @Override
    @Transactional
    public Doctor getDoctorById(int id) {
        // TODO Auto-generated method stub
        return doctorDao.getDoctorById(id);
    }


    @LogThis
    @Override
    @Transactional
    public Doctor signUpDoctor(Doctor doctor) {
        
        return doctorDao.addDoctor(doctor);
    }


    @LogThis
    @Override
    @Transactional
    public Doctor updateDoctorById(int id,Doctor doctor) {
        // TODO Auto-generated method stub
        return doctorDao.updateDoctorById(id, doctor);
    }
    
}
