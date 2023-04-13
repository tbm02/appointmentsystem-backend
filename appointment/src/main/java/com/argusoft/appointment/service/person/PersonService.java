package com.argusoft.appointment.service.person;

import java.util.List;

import com.argusoft.appointment.entity.Person;
import com.argusoft.appointment.utils.customexceptions.UnAuthenticatedException;

public interface PersonService {
    public Person signUpPerson(Person person);
    public Person authenticatePerson(String email,String password) throws UnAuthenticatedException;
    public List<Person> getAllPersons();
    public Person getPersonById(int id);
    public Person updatePersonById(int id,Person person);
    public Person deletePersonById(int id);
}
