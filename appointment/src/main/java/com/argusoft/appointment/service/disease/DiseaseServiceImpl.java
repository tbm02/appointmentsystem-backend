package com.argusoft.appointment.service.disease;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.appointment.dao.disease.DiseaseDao;
import com.argusoft.appointment.entity.Disease;
import com.argusoft.appointment.utils.customannotations.LogThis;
import com.argusoft.appointment.utils.customexceptions.UnAuthenticatedException;

import jakarta.transaction.Transactional;

@Service
public class DiseaseServiceImpl implements DiseaseService{

    public DiseaseServiceImpl(){
        System.out.println("Service Layer Being initalised");
    }
    @Autowired
    private DiseaseDao diseaseDao;




    @LogThis
    @Override
    @Transactional
    public Disease deleteDiseaseById(int id) {
        // TODO Auto-generated method stub
        return diseaseDao.deleteDiseaseById(id);
    }

    @LogThis
    @Override
    @Transactional
    public List<Disease> getAllDiseases() {
        // TODO Auto-generated method stub
        return diseaseDao.getDiseases();
    }


    @LogThis
    @Override
    @Transactional
    public Disease getDiseaseById(int id) {
        // TODO Auto-generated method stub
        return diseaseDao.getDiseaseById(id);
    }


    @LogThis
    @Override
    @Transactional
    public Disease addDisease(Disease disease) {
        
        return diseaseDao.addDisease(disease);
    }


    @LogThis
    @Override
    @Transactional
    public Disease updateDiseaseById(int id,Disease disease) {
   
        return diseaseDao.updateDiseaseById(id, disease);
    }
}
