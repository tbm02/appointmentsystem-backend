package com.argusoft.appointment.service.specialization;

import java.util.List;

import com.argusoft.appointment.entity.Specialization;

public interface SpecializationService {
    public Specialization addSpecialization(Specialization specialization);
    public List<Specialization> getAllSpecializations();
    public Specialization getSpecializationById(int id);
    public Specialization updateSpecializationById(int id,Specialization specialization);
    public Specialization deleteSpecializationById(int id);
}
