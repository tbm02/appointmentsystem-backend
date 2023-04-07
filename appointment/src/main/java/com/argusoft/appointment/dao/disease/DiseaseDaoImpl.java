package com.argusoft.appointment.dao.disease;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.argusoft.appointment.entity.Disease;
import com.argusoft.appointment.utils.customannotations.LogThis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class DiseaseDaoImpl implements DiseaseDao{
    @Autowired
    private EntityManager entityManager;


    @LogThis
    @Override
    public Disease addDisease(Disease disease) {
       
        
        entityManager.persist(disease);
        return disease;
    }


    @LogThis
    @Override
    public Disease deleteDiseaseById(int id) {
        
        Disease disease = entityManager.find(Disease.class,id);
        
        entityManager.remove(disease);
        return disease;
    }


    @LogThis
    @Override
    public Disease getDiseaseById(int id) {
        
        Disease disease = entityManager.find(Disease.class, id);

        return disease;
    }


    @LogThis
    @Override
    public List<Disease> getDiseases() {
        
        TypedQuery<Disease> query = entityManager.createQuery("from Disease",Disease.class);
        List<Disease> data = query.getResultList();
        return data;
    }

    @LogThis
    @Override
    public Disease updateDiseaseById(int id,Disease updateDisease) {
        updateDisease.setDiseaseId(id);
        Disease updatedDisease = entityManager.merge(updateDisease);
        return updatedDisease;
    }


    @LogThis
    @Override
    public List<Disease> getDiseaseByParam(String paramName,String paramValue) {
        System.out.println("Reached the request here "+paramName+"= = = ="+paramValue);
        String ql = "select u from Disease u where u."+paramName+"=:id";

        TypedQuery<Disease> query = entityManager.createQuery(ql, Disease.class);
        query.setParameter("id",paramValue);
        
        List<Disease> diseaseList =  query.getResultList();

        return diseaseList;
    }



    public DiseaseDaoImpl(){
        System.out.println("Hii Confirmation from the dao layer ===========");
    }
    
}
