package com.argusoft.appointment.dao.consumer;

import java.util.List;

import com.argusoft.appointment.entity.Consumer;

public interface ConsumerDao {

    public Consumer addConsumer(Consumer consumer) ;
    public List<Consumer> getConsumers();
    public Consumer getConsumerById(int id);
    public Consumer updateConsumerById(int id,Consumer updatedConsumer);
    public Consumer deleteConsumerById(int id);  
    public List<Consumer> getConsumerByParam(String paramName,String paramValue); 
    
}
