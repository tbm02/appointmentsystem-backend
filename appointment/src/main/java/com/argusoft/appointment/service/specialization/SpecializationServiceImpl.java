package com.argusoft.appointment.service.specialization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import com.argusoft.appointment.dao.specialization.SpecializationDao;
import com.argusoft.appointment.entity.Specialization;
import com.argusoft.appointment.utils.customannotations.LogThis;
import jakarta.transaction.Transactional;


@Service
public class SpecializationServiceImpl implements SpecializationService {

    public SpecializationServiceImpl(){
        System.out.println("Service Layer Being initalised");
    }
    @Autowired
    private SpecializationDao specializationDao;


   
    @LogThis
    @Override
    @Transactional
    public Specialization deleteSpecializationById(int id) {
        
        return specializationDao.deleteSpecializationById(id);
    }

    @LogThis
    @Override
    @Transactional
    public List<Specialization> getAllSpecializations() {
       
        return specializationDao.getSpecializations();
    }


    @LogThis
    @Override
    @Transactional
    public Specialization getSpecializationById(int id) {
       
        return specializationDao.getSpecializationById(id);
    }


    @LogThis
    @Override
    @Transactional
    public Specialization addSpecialization(Specialization specialization) throws DuplicateKeyException{
        if((specialization.getSpecializationId() != 0 && specializationDao.getSpecializationById(specialization.getSpecializationId()) != null) ){
            throw new DuplicateKeyException("specialization with same id already exist");
        }
        return specializationDao.addSpecialization(specialization);
    }


    @LogThis
    @Override
    @Transactional
    public Specialization updateSpecializationById(int id,Specialization specialization) {
       
        return specializationDao.updateSpecializationById(id, specialization);
    }
    
    
}
