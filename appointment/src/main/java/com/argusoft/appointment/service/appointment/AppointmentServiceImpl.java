package com.argusoft.appointment.service.appointment;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
// import java.util.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.appointment.dao.appointment.AppointmentDao;
import com.argusoft.appointment.dao.doctor.DoctorDao;
import com.argusoft.appointment.dao.patient.PatientDao;
import com.argusoft.appointment.entity.Appointment;
import com.argusoft.appointment.entity.Doctor;
import com.argusoft.appointment.utils.DataTypeEnums.Slot;
import com.argusoft.appointment.utils.customannotations.LogThis;

import jakarta.transaction.Transactional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
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
        appointment.setPatient(patientDao.getPatientById(appointment.getPatient().getPatientId()));
        appointment.setDoctor(doctorDao.getDoctorById(appointment.getDoctor().getDoctorId()));
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

    @LogThis
    @Transactional
    @Override
    public List<Appointment> getAppointmentsByQueryParams(Map<String, Object> queries) {
        return appointmentDao.getAppointmentByQueryParam(queries);
    }

    @LogThis
    @Transactional
    @Override
    public List<Slot> getAvailableSlotsForADoctor(int doctorId, Date appointmentDate) {

        Doctor doctor = doctorDao.getDoctorById(doctorId);
        Map<String, Object> params = new HashMap<>();
        params.put("doctor.doctorId", String.valueOf(doctorId));
        params.put("appointmentDate", appointmentDate);
        List<Appointment> doctorsBookedAppointments = appointmentDao.getAppointmentByQueryParam(params);

        List<Slot> slots = null;
        // List<Appointment> appointments = appointmentDao.
        if (doctor != null) {
            slots = new ArrayList();

            Time startTimeSql = doctor.getStartTime();
            Time endTimeSql = doctor.getEndTime();
            Time recessStartTimeSql = doctor.getRecessStartTime();
            Time recessEndTimeSql = doctor.getRecessEndTime();
            LocalTime startTime = LocalTime.of(startTimeSql.getHours(), startTimeSql.getMinutes(),
                    startTimeSql.getSeconds());
            LocalTime endTime = LocalTime.of(endTimeSql.getHours(), endTimeSql.getMinutes(), endTimeSql.getSeconds());
            LocalTime recessStartTime = LocalTime.of(recessStartTimeSql.getHours(), recessStartTimeSql.getMinutes(),
                    recessStartTimeSql.getSeconds());
            LocalTime recessEndTime = LocalTime.of(recessEndTimeSql.getHours(), recessEndTimeSql.getMinutes(),
                    recessEndTimeSql.getSeconds());
            LocalTime temp = startTime;
            while (temp.compareTo(endTime) <= 0) {

                if (!(temp.compareTo(recessStartTime) >= 0 && temp.compareTo(recessEndTime) <= 0)) {

                    slots.add(new Slot(temp, false));

                }
                temp = temp.plusMinutes((doctor.getSlotDuration() + doctor.getBufferTime()));
            }

        }
        return slots;
    }

}
