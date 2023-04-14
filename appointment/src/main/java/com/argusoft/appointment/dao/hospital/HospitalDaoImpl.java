package com.argusoft.appointment.dao.hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.argusoft.appointment.entity.Hospital;
import com.argusoft.appointment.utils.customannotations.LogThis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

@Repository
public class HospitalDaoImpl implements HospitalDao {
    @Autowired
    private EntityManager entityManager;

    @LogThis
    @Override
    public Hospital addHospital(Hospital hospital) {

        entityManager.persist(hospital);
        return hospital;
    }

    @LogThis
    @Override
    public Hospital deleteHospitalById(int id) {

        Hospital hospital = entityManager.find(Hospital.class, id);
        if (hospital != null) {
            entityManager.remove(hospital);
            return hospital;
        } else {
            throw new NoResultException("Requested Hospital does not exists");
        }
    }

    @LogThis
    @Override
    public Hospital updateHospitalById(int id, Hospital updateHospital) {

        Hospital hospital = entityManager.find(Hospital.class, id);
        if (hospital != null) {
            updateHospital.setHospitalId(id);
            if (updateHospital.getRole() == null) {
                updateHospital.setRole(hospital.getRole());

            }

            Hospital updatedHospital = entityManager.merge(updateHospital);

            return updatedHospital;
        } else {
            throw new NoResultException("Requested Hospital Does not exists");
        }
    }

    @LogThis
    @Override
    public Hospital getHospitalById(int id) {

        Hospital hospital = entityManager.find(Hospital.class, id);

        return hospital;
    }

    @LogThis
    @Override
    public List<Hospital> getHospitals() {

        TypedQuery<Hospital> query = entityManager.createQuery("from Hospital", Hospital.class);
        List<Hospital> data = query.getResultList();
        return data;
    }

    @LogThis
    @Override
    public List<Hospital> getHospitalByParam(String paramName, String paramValue) {
        System.out.println("Reached the request here " + paramName + "= = = =" + paramValue);
        String ql = "select u from Hospital u where u." + paramName + "=:id";

        TypedQuery<Hospital> query = entityManager.createQuery(ql, Hospital.class);
        query.setParameter("id", paramValue);

        List<Hospital> hospitalList = query.getResultList();

        return hospitalList;
    }

    public HospitalDaoImpl() {
        System.out.println("Hii Confirmation from the dao layer ===========");
    }
}
