package com.argusoft.appointment.dao.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.argusoft.appointment.entity.Person;
import com.argusoft.appointment.utils.customannotations.LogThis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;


@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private EntityManager entityManager;


    @LogThis
    @Override
    public Person addPerson(Person person) {
       
        
        entityManager.persist(person);
        return person;
    }

 
    @LogThis
    @Override
    public Person deletePersonById(int id) {

        Person person = entityManager.find(Person.class, id);
        if (person != null) {
            entityManager.remove(person);
            return person;
        } else {
            throw new NoResultException("Requested Person does not exists");
        }
    }

    @LogThis
    @Override
    public Person updatePersonById(int id, Person updatePerson) {

        Person person = entityManager.find(Person.class, id);
        if(person != null){
        updatePerson.setPersonId(id);
        if(updatePerson.getAddress()==null){
            updatePerson.setAddress(person.getAddress());

        }
        if(updatePerson.getRole()==null){
            updatePerson.setRole(person.getRole());

        }

        return entityManager.merge(updatePerson);}
        else{
            throw new NoResultException("Requested Person Does not exists");
        }
    }

    @LogThis
    @Override
    public Person getPersonById(int id) {
        
        return entityManager.find(Person.class, id);
    }


    @LogThis
    @Override
    public List<Person> getPersons() {
        
        TypedQuery<Person> query = entityManager.createQuery("from Person",Person.class);
        return query.getResultList();
    }


    @LogThis
    @Override
    public <T,V> List<Person> getPersonByParam(String paramName,T paramType,V paramValue) {
        System.out.println("Reached the request here "+paramName+"= = = ="+paramValue);
        String ql = "select u from Person u where u."+paramName+"=:id";

        TypedQuery<Person> query = entityManager.createQuery(ql, Person.class);
        query.setParameter("id",paramValue);
        
        return query.getResultList();
    }



    public PersonDaoImpl(){
        System.out.println("Hii Confirmation from the dao layer ===========");
    }
    
    
}
