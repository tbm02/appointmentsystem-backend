package com.argusoft.appointment.dao.appointment;

import java.util.List;
import java.util.Map;

import com.argusoft.appointment.entity.Appointment;

public interface AppointmentDao {

    public Appointment addAppointment(Appointment appointment) ;
    public List<Appointment> getAppointments();
    public Appointment getAppointmentById(int id);
    public Appointment updateAppointmentById(int id,Appointment updatedAppointment);
    public Appointment deleteAppointmentById(int id);  
    public <T> List<Appointment> getAppointmentByParam(String paramName,T paramValue); 
    public  List<Appointment> getAppointmentByQueryParam(Map<String,String> queires); 
}
