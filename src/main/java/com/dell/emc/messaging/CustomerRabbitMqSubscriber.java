package com.candidjava.springboot.subcriber;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
public class CustomerRabbitMqSubscriber {
   @RabbitListener(queues="spring.rabbitmq.queue")
    public void receivedMessage(String msg) {
        System.out.println("Received Message: " + msg);
    }
}