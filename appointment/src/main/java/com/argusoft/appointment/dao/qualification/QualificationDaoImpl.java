package com.argusoft.appointment.dao.qualification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.argusoft.appointment.entity.Qualification;
import com.argusoft.appointment.utils.customannotations.LogThis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

@Repository
public class QualificationDaoImpl implements QualificationDao{
    @Autowired
    private EntityManager entityManager;

    @LogThis
    @Override
    public Qualification addQualification(Qualification qualification) {

        entityManager.persist(qualification);
        return qualification;
    }

    @LogThis
    @Override
    public Qualification deleteQualificationById(int id) {

        Qualification qualification = entityManager.find(Qualification.class, id);
        if (qualification != null) {
            entityManager.remove(qualification);
            return qualification;
        } else {
            throw new NoResultException("Requested Qualification does not exists");
        }
    }

    @LogThis
    @Override
    public Qualification getQualificationById(int id) {

        Qualification qualification = entityManager.find(Qualification.class, id);
        if (qualification != null)
            return qualification;

        else {
            throw new NoResultException("Requested Qualification does not exists");
        }
    }

    @LogThis
    @Override
    public List<Qualification> getQualifications() {

        TypedQuery<Qualification> query = entityManager.createQuery("from Qualification", Qualification.class);
        List<Qualification> data = query.getResultList();
        return data;
    }

    @LogThis
    @Override
    public Qualification updateQualificationById(int id, Qualification updateQualification) {

        Qualification qualification = entityManager.find(Qualification.class, id);
        if(qualification != null){
        updateQualification.setQualificationId(id);


        Qualification updatedQualification = entityManager.merge(updateQualification);

        return updatedQualification;}
        else{
            throw new NoResultException("Requested Qualification Does not exists");
        }
    }

    @LogThis
    @Override
    public List<Qualification> getQualificationByParam(String paramName, String paramValue) {
        System.out.println("Reached the request here " + paramName + "= = = =" + paramValue);
        String ql = "select u from Qualification u where u." + paramName + "=:id";

        TypedQuery<Qualification> query = entityManager.createQuery(ql, Qualification.class);
        query.setParameter("id", paramValue);

        List<Qualification> qualificationList = query.getResultList();

        return qualificationList;
    }

    public QualificationDaoImpl() {
        // System.out.println("Hii Confirmation from the dao layer ===========");
    }
}
