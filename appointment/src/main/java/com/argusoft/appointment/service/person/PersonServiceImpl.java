package com.argusoft.appointment.service.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.appointment.dao.patient.PatientDao;
import com.argusoft.appointment.dao.person.PersonDao;
import com.argusoft.appointment.dao.role.RoleDao;
import com.argusoft.appointment.entity.Patient;
import com.argusoft.appointment.entity.Person;
import com.argusoft.appointment.entity.Role;
import com.argusoft.appointment.utils.customannotations.LogThis;
import com.argusoft.appointment.utils.customexceptions.UnAuthenticatedException;

import jakarta.transaction.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

    public PersonServiceImpl() {
        System.out.println("Service Layer Being initalised");
    }

    @Autowired
    private PersonDao personDao;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    RoleDao roleDao;

    @LogThis
    @Override
    @Transactional
    public Person deletePersonById(int id) {

        return personDao.deletePersonById(id);
    }

    @LogThis
    @Override
    @Transactional
    public List<Person> getAllPersons() {

        return personDao.getPersons();
    }

    @LogThis
    @Override
    @Transactional
    public Person getPersonById(int id) {

        return personDao.getPersonById(id);
    }

    @LogThis
    @Override
    @Transactional
    public Person authenticatePerson(String email, String password) throws UnAuthenticatedException {

        return null;
    }

    @LogThis
    @Override
    @Transactional
    public Person signUpPerson(Person person) {
        try {
            Role role = roleDao.getRoleByParam("roleName", "SystemUser").get(0);
            person.setRole(role);
            Person addedPerson = personDao.addPerson(person);
            Patient newPatient = new Patient();
            newPatient.setFirstName(person.getFirstName());
            newPatient.setLastName(person.getLastName());
            newPatient.setEmail(person.getEmail());
            newPatient.setContactNo(person.getContactNo());
            newPatient.setDob(person.getDob());
            newPatient.setPerson(addedPerson);
            patientDao.addPatient(newPatient);
            
            return addedPerson;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }

    }

    @LogThis
    @Override
    @Transactional
    public Person updatePersonById(int id, Person person) {

        return personDao.updatePersonById(id, person);
    }
}
