package com.argusoft.appointment.dao.appointment;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.argusoft.appointment.entity.Appointment;
import com.argusoft.appointment.utils.customannotations.LogThis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;


@Repository
public class AppointmentDaoImpl implements AppointmentDao {

    @Autowired
    private EntityManager entityManager;


    @LogThis
    @Override
    public Appointment addAppointment(Appointment appointment) {
       
        
        entityManager.persist(appointment);
        return appointment;
    }



    @LogThis
    @Override
    public Appointment deleteAppointmentById(int id) {

        Appointment appointment = entityManager.find(Appointment.class, id);
        if (appointment != null) {
            entityManager.remove(appointment);
            return appointment;
        } else {
            throw new NoResultException("Requested Appointment does not exists");
        }
    }

    @LogThis
    @Override
    public Appointment updateAppointmentById(int id, Appointment updateAppointment) {

        Appointment appointment = entityManager.find(Appointment.class, id);
        if(appointment != null){
        updateAppointment.setAppointmentId(id);


        Appointment updatedAppointment = entityManager.merge(updateAppointment);

        return updatedAppointment;}
        else{
            throw new NoResultException("Requested Appointment Does not exists");
        }
    }

    @LogThis
    @Override
    public Appointment getAppointmentById(int id) {
        
        Appointment appointment = entityManager.find(Appointment.class, id);

        return appointment;
    }


    @LogThis
    @Override
    public List<Appointment> getAppointments() {
        
        TypedQuery<Appointment> query = entityManager.createQuery("from Appointment",Appointment.class);
        List<Appointment> data = query.getResultList();
        return data;
    }

 
    @LogThis
    @Override
    public <T> List<Appointment> getAppointmentByParam(String paramName,T paramValue) {
        System.out.println("Reached the request here "+paramName+"= = = ="+paramValue);
        String ql = "select u from Appointment u where u."+paramName+"=:id";

        TypedQuery<Appointment> query = entityManager.createQuery(ql, Appointment.class);
        query.setParameter("id",paramValue);
        
        List<Appointment> appointmentList =  query.getResultList();

        return appointmentList;
    }

    @LogThis
    @Override
    public List<Appointment> getAppointmentByQueryParam(Map<String,String> queries) {
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
        String ql = "FROM Appointment WHERE "+whereSegment;
        System.out.println(ql);

        TypedQuery<Appointment> query = entityManager.createQuery(ql, Appointment.class);
       
        for(String value:queries.values()){
            query.setParameter(++counter,value);
            System.out.println(query.getParameterValue(counter));
            // System.out.println(counter+""+value);
        }
        List<Appointment> appointmentList =  query.getResultList();
        // System.out.println(appointmentList);
        return appointmentList;
    }



    public AppointmentDaoImpl(){
        System.out.println("Hii Confirmation from the dao layer ===========");
    }
    
    
}
