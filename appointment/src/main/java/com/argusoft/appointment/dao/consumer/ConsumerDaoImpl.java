package com.argusoft.appointment.dao.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.argusoft.appointment.entity.Consumer;
import com.argusoft.appointment.utils.customannotations.LogThis;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;


@Repository
public class ConsumerDaoImpl implements ConsumerDao {

    @Autowired
    private EntityManager entityManager;


    @LogThis
    @Override
    public Consumer addConsumer(Consumer consumer) {
       
        
        entityManager.persist(consumer);
        return consumer;
    }


    // @LogThis
    // @Override
    // public Consumer deleteConsumerById(int id) {
        
    //     Consumer consumer = entityManager.find(Consumer.class,id);
        
    //     entityManager.remove(consumer);
    //     return consumer;
    // }

    @LogThis
    @Override
    public Consumer deleteConsumerById(int id) {

        Consumer consumer = entityManager.find(Consumer.class, id);
        if (consumer != null) {
            entityManager.remove(consumer);
            return consumer;
        } else {
            throw new NoResultException("Requested Consumer does not exists");
        }
    }

    @LogThis
    @Override
    public Consumer updateConsumerById(int id, Consumer updateConsumer) {

        Consumer consumer = entityManager.find(Consumer.class, id);
        if(consumer != null){
        updateConsumer.setConsumerId(id);


        return entityManager.merge(updateConsumer);}
        else{
            throw new NoResultException("Requested Consumer Does not exists");
        }
    }

    @LogThis
    @Override
    public Consumer getConsumerById(int id) {
        
        return entityManager.find(Consumer.class, id);
    }


    @LogThis
    @Override
    public List<Consumer> getConsumers() {
        
        TypedQuery<Consumer> query = entityManager.createQuery("from Consumer",Consumer.class);
        return query.getResultList();
    }

    // @LogThis
    // @Override
    // public Consumer updateConsumerById(int id,Consumer updateConsumer) {
    //     updateConsumer.setConsumerId(id);
    //     Consumer updatedConsumer = entityManager.merge(updateConsumer);
    //     return updatedConsumer;
    // }


    @LogThis
    @Override
    public List<Consumer> getConsumerByParam(String paramName,String paramValue) {
        System.out.println("Reached the request here "+paramName+"= = = ="+paramValue);
        String ql = "select u from Consumer u where u."+paramName+"=:id";

        TypedQuery<Consumer> query = entityManager.createQuery(ql, Consumer.class);
        query.setParameter("id",paramValue);
        
        return query.getResultList();
    }



    public ConsumerDaoImpl(){
        System.out.println("Hii Confirmation from the dao layer ===========");
    }
    
    
}
