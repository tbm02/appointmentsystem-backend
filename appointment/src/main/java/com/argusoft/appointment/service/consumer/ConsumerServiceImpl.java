package com.argusoft.appointment.service.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argusoft.appointment.dao.consumer.ConsumerDao;
import com.argusoft.appointment.entity.Consumer;
import com.argusoft.appointment.utils.customannotations.LogThis;
import com.argusoft.appointment.utils.customexceptions.UnAuthenticatedException;

import jakarta.transaction.Transactional;

@Service
public class ConsumerServiceImpl implements ConsumerService{

    public ConsumerServiceImpl(){
        System.out.println("Service Layer Being initalised");
    }
    @Autowired
    private ConsumerDao consumerDao;




    @LogThis
    @Override
    @Transactional
    public Consumer deleteConsumerById(int id) {
        // TODO Auto-generated method stub
        return consumerDao.deleteConsumerById(id);
    }

    @LogThis
    @Override
    @Transactional
    public List<Consumer> getAllConsumers() {
        // TODO Auto-generated method stub
        return consumerDao.getConsumers();
    }


    @LogThis
    @Override
    @Transactional
    public Consumer getConsumerById(int id) {
        // TODO Auto-generated method stub
        return consumerDao.getConsumerById(id);
    }


    @LogThis
    @Override
    @Transactional
    public Consumer authenticateConsumer( String email,  String password) throws UnAuthenticatedException {
//         // TODO Auto-generated method stub
        
//         Consumer consumer = consumerDao.getConsumerByParam("email",email).get(0);
//         if(consumer.getPassword().equals(password)){
//             System.out.println("Consumer Found and credentials matched");
//             return consumer;
//         }
//         else{
//         throw new UnAuthenticatedException("Invalide credenyials");
//  }       
 
 return null;
    }
    @LogThis
    @Override
    @Transactional
    public Consumer signUpConsumer(Consumer consumer) {
        
        return consumerDao.addConsumer(consumer);
    }

    @LogThis
    @Override
    @Transactional
    public Consumer updateConsumerById(int id,Consumer consumer) {
   
        return consumerDao.updateConsumerById(id, consumer);
    }
}
