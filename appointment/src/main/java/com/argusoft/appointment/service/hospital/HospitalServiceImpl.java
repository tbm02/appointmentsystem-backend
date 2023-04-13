package com.argusoft.appointment.service.hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.appointment.dao.hospital.HospitalDao;
import com.argusoft.appointment.entity.Hospital;
import com.argusoft.appointment.utils.customannotations.LogThis;
import com.argusoft.appointment.utils.customexceptions.UnAuthenticatedException;

import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;

@Service
public class HospitalServiceImpl implements HospitalService{
    public HospitalServiceImpl(){
        System.out.println("Service Layer Being initalised");
    }
    @Autowired
    private HospitalDao hospitalDao;


    @LogThis
    @Override
    @Transactional
    public Hospital authenticateHospital( String email,  String password) throws UnAuthenticatedException {
        // TODO Auto-generated method stub
        
//         Hospital hospital = hospitalDao.getHospitalByParam("email",email).get(0);
//         if(hospital == null){
//             throw new NoResultException("Requested Hos")
//         }
//         if(hospital.getUserId().getPassword().equals(password)){
//             System.out.println("Hospital Found and credentials matched");
//             return hospital;
//         }
//         else{
//         throw new UnAuthenticatedException("Invalide credenyials");
//  }       
 
 return null;
    }

    @LogThis
    @Override
    @Transactional
    public Hospital deleteHospitalById(int id) {
      
        return hospitalDao.deleteHospitalById(id);
    }

    @LogThis
    @Override
    @Transactional
    public List<Hospital> getAllHospitals() {
        // TODO Auto-generated method stub
        return hospitalDao.getHospitals();
    }


    @LogThis
    @Override
    @Transactional
    public Hospital getHospitalById(int id) {
        // TODO Auto-generated method stub
        return hospitalDao.getHospitalById(id);
    }


    @LogThis
    @Override
    @Transactional
    public Hospital signUpHospital(Hospital hospital) {
        
        return hospitalDao.addHospital(hospital);
    }


    @LogThis
    @Override
    @Transactional
    public Hospital updateHospitalById(int id,Hospital hospital) {
       
        return hospitalDao.updateHospitalById(id, hospital);
    }
    
}
