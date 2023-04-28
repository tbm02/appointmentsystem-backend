package com.argusoft.appointment.service.appointment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.appointment.dao.appointment.AppointmentDao;
import com.argusoft.appointment.dao.doctor.DoctorDao;
import com.argusoft.appointment.dao.patient.PatientDao;
import com.argusoft.appointment.entity.Appointment;
import com.argusoft.appointment.utils.customannotations.LogThis;

import jakarta.transaction.Transactional;


@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentDao appointmentDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private PatientDao patientDao;
    @LogThis
    @Transactional
    @Override
    public Appointment createNewAppointment(Appointment appointment) {
        // appointment.setPatient(patientDao.getPatientById(appointment.getPatient().getPatientId()));
        return appointmentDao.addAppointment(appointment);
    }


    @LogThis
    @Transactional
    @Override
    public Appointment deleteAppointmentById(int id) {
        return appointmentDao.deleteAppointmentById(id);
    }


    @LogThis
    @Transactional
    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentDao.getAppointments();
    }

    @LogThis
    @Transactional
    @Override
    public Appointment getAppointmentByAppointmentId(int appointmentId) {
        return appointmentDao.getAppointmentById(appointmentId);
    }

    @LogThis
    @Transactional
    @Override
    public List<Appointment> getAppointmentByDoctorId(int doctorId) {
        return appointmentDao.getAppointmentByParam("doctor.doctorId", doctorId);
    }

    @LogThis
    @Transactional
    @Override
    public List<Appointment> getAppointmentByHospitalId(int hospitalId) {
        return appointmentDao.getAppointmentByParam("doctor.hospital.hospitalId", hospitalId);
    }

    @LogThis
    @Transactional
    @Override
    public List<Appointment> getAppointmentByPatientId(int patientId) {
        return appointmentDao.getAppointmentByParam("patient.patientId", patientId);
    }

    @LogThis
    @Transactional
    @Override
    public List<Appointment> getAppointmentByPersonId(int personId) {
        return appointmentDao.getAppointmentByParam("patient.person.personId", personId);
    }

    @LogThis
    @Transactional
    @Override
    public Appointment updateAppointmentById(int id, Appointment appointment) {
        return appointmentDao.updateAppointmentById(id, appointment);
    }
    
    
}
