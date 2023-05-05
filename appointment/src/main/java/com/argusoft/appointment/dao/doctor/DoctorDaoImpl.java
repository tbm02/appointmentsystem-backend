package com.argusoft.appointment.dao.doctor;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.argusoft.appointment.entity.Doctor;
import com.argusoft.appointment.entity.Hospital;
import com.argusoft.appointment.utils.customannotations.LogThis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;


@Repository
public class DoctorDaoImpl implements DoctorDao {

    @Autowired
    private EntityManager entityManager;


    @LogThis
    @Override
    public Doctor addDoctor(Doctor doctor) {
       
        
        Hospital tempHospital = entityManager.find(Hospital.class, doctor.getHospital().getHospitalId());
        if(tempHospital == null){
            throw new NoResultException("Requested Hospital does not exists in records");
        }
        doctor.setHospital(tempHospital);
        entityManager.persist(doctor);
        return doctor;
    }


    @LogThis
    @Override
    public Doctor deleteDoctorById(int id) {

        Doctor doctor = entityManager.find(Doctor.class, id);
        if (doctor != null) {
            entityManager.remove(doctor);
            return doctor;
        } else {
            throw new NoResultException("Requested Doctor does not exists");
        }
    }

    @LogThis
    @Override
    public Doctor updateDoctorById(int id, Doctor updateDoctor) {

        Doctor doctor = entityManager.find(Doctor.class, id);
        if(doctor != null){
        updateDoctor.setDoctorId(id);
        updateDoctor.setUser(doctor.getUser());


      

        return  entityManager.merge(updateDoctor);}
        else{
            throw new NoResultException("Requested Doctor Does not exists");
        }
    }

    @LogThis
    @Override
    public Doctor getDoctorById(int id) {
        
        Doctor doctor = entityManager.find(Doctor.class, id);
        if(doctor == null){
            throw new NoResultException("Requested Doctor does not exists");
        }

        return doctor;
    }


    @LogThis
    @Override
    public List<Doctor> getDoctors() {
        
        TypedQuery<Doctor> query = entityManager.createQuery("from Doctor",Doctor.class);
      
        return query.getResultList();
    }

   

    @LogThis
    @Override
    public <T> List<Doctor> getDoctorByParam(String paramName,T paramValue) {
        System.out.println("Reached the request here "+paramName+"= = = ="+paramValue);
        String ql = "SELECT d FROM Doctor d WHERE d."+paramName+" = :id";
        System.out.println(ql);
        TypedQuery<Doctor> query = entityManager.createQuery(ql, Doctor.class);
        // Query query = entityManager.createNativeQuery(ql);
        query.setParameter("id",paramValue);
    

        return query.getResultList();
    }



    public DoctorDaoImpl(){
        System.out.println("Hii Confirmation from the dao layer ===========");
    }
    @LogThis
    @Override
    public List<Doctor> getDoctorByQueryParam(Map<String,String> queries) {
        // System.out.println("Reached the request here "+paramName+"= = = ="+paramValue);
        String whereSegment = "";
        int counter = 0;
        for(String key:queries.keySet()){
            counter++;
            if(whereSegment.equals("")){
                whereSegment += ""+ key+"= ?"+counter;
            }
            else{
                whereSegment += " and "+key+"=?"+counter;
            }
            
        }
        counter = 0;
        String ql = "FROM Doctor WHERE "+whereSegment;
        System.out.println(ql);

        TypedQuery<Doctor> query = entityManager.createQuery(ql, Doctor.class);
       
        for(String value:queries.values()){
            query.setParameter(++counter,value);
            System.out.println(query.getParameterValue(counter));
            // System.out.println(counter+""+value);
        }
        List<Doctor> appointmentList =  query.getResultList();
        // System.out.println(appointmentList);
        return appointmentList;
    }


    
    
}
