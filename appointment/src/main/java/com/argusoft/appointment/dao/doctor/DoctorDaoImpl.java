package com.argusoft.appointment.dao.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.argusoft.appointment.entity.Doctor;
import com.argusoft.appointment.utils.customannotations.LogThis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;


@Repository
public class DoctorDaoImpl implements DoctorDao {

    @Autowired
    private EntityManager entityManager;


    @LogThis
    @Override
    public Doctor addDoctor(Doctor user) {
       
        
        entityManager.persist(user);
        return user;
    }


    @LogThis
    @Override
    public Doctor deleteDoctorById(int id) {
        
        Doctor user = entityManager.find(Doctor.class,id);
        
        entityManager.remove(user);
        return user;
    }


    @LogThis
    @Override
    public Doctor getDoctorById(int id) {
        
        Doctor user = entityManager.find(Doctor.class, id);

        return user;
    }


    @LogThis
    @Override
    public List<Doctor> getDoctors() {
        
        TypedQuery<Doctor> query = entityManager.createQuery("from Doctor",Doctor.class);
        List<Doctor> data = query.getResultList();
        return data;
    }

    @LogThis
    @Override
    public Doctor updateDoctorById(int id,Doctor updateDoctor) {
        updateDoctor.setDoctorId(id);
        Doctor updatedDoctor = entityManager.merge(updateDoctor);
        return updatedDoctor;
    }


    @LogThis
    @Override
    public List<Doctor> getDoctorByParam(String paramName,String paramValue) {
        System.out.println("Reached the request here "+paramName+"= = = ="+paramValue);
        String ql = "select u from Doctor u where u."+paramName+"=:id";

        TypedQuery<Doctor> query = entityManager.createQuery(ql, Doctor.class);
        query.setParameter("id",paramValue);
        
        List<Doctor> userList =  query.getResultList();

        return userList;
    }



    public DoctorDaoImpl(){
        System.out.println("Hii Confirmation from the dao layer ===========");
    }
    
    
}
