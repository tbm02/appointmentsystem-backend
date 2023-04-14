package com.argusoft.appointment.dao.specialization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.argusoft.appointment.entity.Specialization;
import com.argusoft.appointment.utils.customannotations.LogThis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

@Repository
public class SpecializationDaoImpl implements SpecializationDao{
    @Autowired
    private EntityManager entityManager;

    @LogThis
    @Override
    public Specialization addSpecialization(Specialization specialization) {

        entityManager.persist(specialization);
        return specialization;
    }

    @LogThis
    @Override
    public Specialization deleteSpecializationById(int id) {

        Specialization specialization = entityManager.find(Specialization.class, id);
        if (specialization != null) {
            entityManager.remove(specialization);
            return specialization;
        } else {
            throw new NoResultException("Requested Specialization does not exists");
        }
    }

    @LogThis
    @Override
    public Specialization getSpecializationById(int id) {

        Specialization specialization = entityManager.find(Specialization.class, id);
        if (specialization != null)
            return specialization;

        else {
            throw new NoResultException("Requested Specialization does not exists");
        }
    }

    @LogThis
    @Override
    public List<Specialization> getSpecializations() {

        TypedQuery<Specialization> query = entityManager.createQuery("from Specialization", Specialization.class);
        List<Specialization> data = query.getResultList();
        return data;
    }

    @LogThis
    @Override
    public Specialization updateSpecializationById(int id, Specialization updateSpecialization) {

        Specialization specialization = entityManager.find(Specialization.class, id);
        if(specialization != null){
        updateSpecialization.setSpecializationId(id);


        Specialization updatedSpecialization = entityManager.merge(updateSpecialization);

        return updatedSpecialization;}
        else{
            throw new NoResultException("Requested Specialization Does not exists");
        }
    }

    @LogThis
    @Override
    public List<Specialization> getSpecializationByParam(String paramName, String paramValue) {
        System.out.println("Reached the request here " + paramName + "= = = =" + paramValue);
        String ql = "select u from Specialization u where u." + paramName + "=:id";

        TypedQuery<Specialization> query = entityManager.createQuery(ql, Specialization.class);
        query.setParameter("id", paramValue);

        List<Specialization> specializationList = query.getResultList();

        return specializationList;
    }

    public SpecializationDaoImpl() {
        // System.out.println("Hii Confirmation from the dao layer ===========");
    }
}
