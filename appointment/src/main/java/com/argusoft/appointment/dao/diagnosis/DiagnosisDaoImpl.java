package com.argusoft.appointment.dao.diagnosis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.argusoft.appointment.entity.Diagnosis;
import com.argusoft.appointment.entity.Disease;
import com.argusoft.appointment.entity.Doctor;
import com.argusoft.appointment.entity.Patient;
import com.argusoft.appointment.utils.customannotations.LogThis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
@Repository
public class DiagnosisDaoImpl implements DiagnosisDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Diagnosis addDiagnosis(Diagnosis diagnosis) {
        Doctor tempDoctor = entityManager.find(Doctor.class, diagnosis.getDoctor().getDoctorId());
        Patient tempPatient = entityManager.find(Patient.class, diagnosis.getPatient().getPatientId());
        Disease tempDisease = entityManager.find(Disease.class, diagnosis.getDisease().getDiseaseId());
        if (diagnosis.getDoctor() == null || tempDoctor == null) {
            throw new IllegalArgumentException("No Such Doctor Exists");
        }
        if (diagnosis.getPatient() == null || tempPatient == null) {
            throw new IllegalArgumentException("No Such Patient Exists");
        }
        diagnosis.setDoctor(tempDoctor);
        diagnosis.setPatient(tempPatient);
        diagnosis.setDisease(tempDisease);
        entityManager.persist(diagnosis);

        return diagnosis;
    }

    @LogThis
    @Override
    public Diagnosis getDiagnosisById(int id) {

        return entityManager.find(Diagnosis.class, id);
    }

    @LogThis
    @Override
    public List<Diagnosis> getDiagnosiss() {

        TypedQuery<Diagnosis> query = entityManager.createQuery("from Diagnosis", Diagnosis.class);
        return query.getResultList();
    }

    @LogThis
    @Override
    public Diagnosis deleteDiagnosisById(int id) {

        Diagnosis diagnosis = entityManager.find(Diagnosis.class, id);
        if (diagnosis != null) {
            entityManager.remove(diagnosis);
            return diagnosis;
        } else {
            throw new NoResultException("Requested Diagnosis does not exists");
        }
    }

    @LogThis
    @Override
    public Diagnosis updateDiagnosisById(int id, Diagnosis updateDiagnosis) {

        Diagnosis diagnosis = entityManager.find(Diagnosis.class, id);
        if (diagnosis != null) {
            updateDiagnosis.setId(id);

            return entityManager.merge(updateDiagnosis);
        } else {
            throw new NoResultException("Requested Diagnosis Does not exists");
        }
    }

    @LogThis
    @Override
    public List<Diagnosis> getDiagnosisByParam(String paramName, String paramValue) {
        System.out.println("Reached the request here " + paramName + "= = = =" + paramValue);
        String ql = "select u from Diagnosis u where u." + paramName + "=:id";

        TypedQuery<Diagnosis> query = entityManager.createQuery(ql, Diagnosis.class);
        query.setParameter("id", paramValue);

        return query.getResultList();
    }

    public DiagnosisDaoImpl() {
        System.out.println("Hii Confirmation from the dao layer ===========");
    }

}
