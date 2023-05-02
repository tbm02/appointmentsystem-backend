package com.argusoft.appointment.service.appointment;

import java.util.List;
import java.util.Map;

import com.argusoft.appointment.entity.Appointment;

public interface AppointmentService {
    public Appointment createNewAppointment(Appointment appointment);
    public List<Appointment> getAllAppointments();
    public Appointment getAppointmentByAppointmentId(int appointmentId);
    public List<Appointment> getAppointmentByDoctorId(int doctorId);
    public List<Appointment> getAppointmentByHospitalId(int hospitalId);
    public List<Appointment> getAppointmentByPersonId(int personId);
    public List<Appointment> getAppointmentByPatientId(int patientId);
    public List<Appointment> getAppointmentsByQueryParams(Map<String,String> queries);
    public Appointment updateAppointmentById(int id, Appointment appointment);
    public Appointment deleteAppointmentById(int id);
}
