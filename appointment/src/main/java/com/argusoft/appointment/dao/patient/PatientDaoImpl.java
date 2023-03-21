package com.argusoft.appointment.dao.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.argusoft.appointment.entity.Patient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class PatientDaoImpl implements PatientDao {


    @Autowired
    private EntityManager entityManager;
    @Override
    public Patient addPatient(Patient patient) {
       
        System.out.println("Inside Dao Layer : Creating the Patient");
        entityManager.persist(patient);
        return patient;
    }

    @Override
    public Patient deletePatientById(int id) {
        
        Patient Patient = getPatientById(id);

        TypedQuery<Patient> query = entityManager.createQuery("delete from Patient where PatientId =:id",Patient.class);
        query.setParameter("id",id);
        query.executeUpdate();
        return Patient;
    }

    @Override
    public Patient getPatientById(int id) {
        
        Patient Patient = entityManager.find(Patient.class, id);

        return Patient;
    }

    @Override
    public List<Patient> getPatients() {
        
        TypedQuery<Patient> query = entityManager.createQuery("from Patient",Patient.class);
        List<Patient> data = query.getResultList();
        return data;
    }

    @Override
    public Patient updatePatientById(int id,Patient updatePatient) {
        
        Patient updatedPatient = entityManager.merge(updatePatient);
        return updatedPatient;
    }

    @Override
    public Patient getPatientByParam(String paramName,String paramValue) {
        System.out.println("Reached the request here "+paramName+"= = = ="+paramValue);
        String ql = "select u from Patient u where u."+paramName+"=:id";

        TypedQuery<Patient> query = entityManager.createQuery(ql, Patient.class);
        query.setParameter("id",paramValue);
        // System.out.println(query.);
        Patient Patient =  query.getSingleResult();

        return Patient;
    }

    public PatientDaoImpl(){
        System.out.println("Hii Confirmation from the dao layer ===========");
    }
    


    
}
