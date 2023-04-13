package com.argusoft.appointment.dao.appointment;

import java.util.List;

import com.argusoft.appointment.entity.Appointment;

public interface AppointmentDao {

    public Appointment addAppointment(Appointment appointment) ;
    public List<Appointment> getAppointments();
    public Appointment getAppointmentById(int id);
    public Appointment updateAppointmentById(int id,Appointment updatedAppointment);
    public Appointment deleteAppointmentById(int id);  
    public <K,V> List<Appointment> getAppointmentByParam(K paramName,V paramValue); 
    
}
