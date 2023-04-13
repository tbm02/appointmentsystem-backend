package com.argusoft.appointment.service.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.appointment.dao.person.PersonDao;
import com.argusoft.appointment.entity.Person;
import com.argusoft.appointment.utils.customannotations.LogThis;
import com.argusoft.appointment.utils.customexceptions.UnAuthenticatedException;

import jakarta.transaction.Transactional;

@Service
public class PersonServiceImpl implements PersonService{

    public PersonServiceImpl(){
        System.out.println("Service Layer Being initalised");
    }
    @Autowired
    private PersonDao personDao;




    @LogThis
    @Override
    @Transactional
    public Person deletePersonById(int id) {
        // TODO Auto-generated method stub
        return personDao.deletePersonById(id);
    }

    @LogThis
    @Override
    @Transactional
    public List<Person> getAllPersons() {
        // TODO Auto-generated method stub
        return personDao.getPersons();
    }


    @LogThis
    @Override
    @Transactional
    public Person getPersonById(int id) {
        // TODO Auto-generated method stub
        return personDao.getPersonById(id);
    }


    @LogThis
    @Override
    @Transactional
    public Person authenticatePerson( String email,  String password) throws UnAuthenticatedException {

 return null;
    }
    @LogThis
    @Override
    @Transactional
    public Person signUpPerson(Person person) {
        
        return personDao.addPerson(person);
    }

    @LogThis
    @Override
    @Transactional
    public Person updatePersonById(int id,Person person) {
   
        return personDao.updatePersonById(id, person);
    }
}
