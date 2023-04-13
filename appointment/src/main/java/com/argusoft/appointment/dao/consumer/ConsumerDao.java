package com.argusoft.appointment.dao.person;

import java.util.List;

import com.argusoft.appointment.entity.Person;

public interface PersonDao {

    public Person addPerson(Person person) ;
    public List<Person> getPersons();
    public Person getPersonById(int id);
    public Person updatePersonById(int id,Person updatedPerson);
    public Person deletePersonById(int id);  
    public List<Person> getPersonByParam(String paramName,String paramValue); 
    
}
