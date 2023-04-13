package com.argusoft.appointment.service.consumer;

import java.util.List;

import com.argusoft.appointment.entity.Consumer;
import com.argusoft.appointment.utils.customexceptions.UnAuthenticatedException;

public interface ConsumerService {
    public Consumer signUpConsumer(Consumer consumer);
    public Consumer authenticateConsumer(String email,String password) throws UnAuthenticatedException;
    public List<Consumer> getAllConsumers();
    public Consumer getConsumerById(int id);
    public Consumer updateConsumerById(int id,Consumer consumer);
    public Consumer deleteConsumerById(int id);
}
