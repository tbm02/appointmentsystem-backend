package com.argusoft.appointment.service.hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.appointment.dao.hospital.HospitalDao;
import com.argusoft.appointment.dao.role.RoleDao;
import com.argusoft.appointment.dao.user.UserDao;
import com.argusoft.appointment.entity.Hospital;
import com.argusoft.appointment.utils.customannotations.LogThis;
import com.argusoft.appointment.utils.customexceptions.UnAuthenticatedException;

import jakarta.transaction.Transactional;

@Service
public class HospitalServiceImpl implements HospitalService{
    public HospitalServiceImpl(){
        System.out.println("Service Layer Being initalised");
    }
    @Autowired
    private HospitalDao hospitalDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;


    @LogThis
    @Override
    @Transactional
    public Hospital authenticateHospital( String email,  String password) throws UnAuthenticatedException {

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
        
        return hospitalDao.getHospitals();
    }


    @LogThis
    @Override
    @Transactional
    public Hospital getHospitalById(int id) {
       
        return hospitalDao.getHospitalById(id);
    }


    @LogThis
    @Override
    @Transactional
    public Hospital signUpHospital(Hospital hospital) {
        hospital.getUser().setRole(roleDao.getRoleByParam("roleName","HospitalAdmin").get(0));
        userDao.addUser(hospital.getUser());
        return hospitalDao.addHospital(hospital);
    }


    @LogThis
    @Override
    @Transactional
    public Hospital updateHospitalById(int id,Hospital hospital) {
       
        return hospitalDao.updateHospitalById(id, hospital);
    }
    
}
