package com.argusoft.appointment.dao.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.argusoft.appointment.entity.Person;
import com.argusoft.appointment.entity.Patient;
import com.argusoft.appointment.entity.User;
import com.argusoft.appointment.utils.customannotations.LogThis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;


@Repository
public class PatientDaoImpl implements PatientDao {


    @Autowired
    private EntityManager entityManager;



    @LogThis
    @Override
    public Patient addPatient(Patient patient) {
       
     
        Person tempPerson = entityManager.find(Person.class, patient.getPerson().getPersonId());
        
        patient.setPerson(tempPerson);
        entityManager.persist(patient);
        return patient;
    }


    @LogThis
    @Override
    public Patient deletePatientById(int id) {
        
        Patient patient = getPatientById(id);

        if(patient!=null){
        entityManager.remove(patient);
        return patient;}
        else{
            throw new NoResultException("Can not delete the patient as it does not exits");
        }
    }


    @LogThis
    @Override
    public Patient getPatientById(int id) {
        
        Patient patient = entityManager.find(Patient.class, id);

        return patient;
    }


    @LogThis
    @Override
    public List<Patient> getPatients() {
        
        TypedQuery<Patient> query = entityManager.createQuery("from Patient",Patient.class);
        List<Patient> data = query.getResultList();
        return data;
    }


    @LogThis
    @Override
    public Patient updatePatientById(int id,Patient updatePatient) {
        Patient temPatient = entityManager.find(Patient.class, id);
        if(temPatient != null){
        updatePatient.setPatientId(id);
        Patient updatedPatient = entityManager.merge(updatePatient);
        return updatedPatient;}
        else{
            throw new NoResultException("Can not update the Requested patient as it does not exists");
        }
    }


    @LogThis
    @Override
    public List<Patient> getPatientByParam(String paramName,String paramValue) {
        



        String ql = "select u from Patient u where u."+paramName+"=:id";

        TypedQuery<Patient> query = entityManager.createQuery(ql, Patient.class);
        query.setParameter("id",paramValue);
        
        List<Patient> patientList =  query.getResultList();

        return patientList;
    }

    public PatientDaoImpl(){
        // System.out.println("Hii Confirmation from the dao layer ===========");
    }
    


    
}
