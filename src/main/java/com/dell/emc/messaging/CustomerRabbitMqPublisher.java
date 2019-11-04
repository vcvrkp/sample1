package com.dell.emc.messaging;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class CustomerRabbitMqPublisher {
   @Autowired
   private AmqpTemplate amqpTemplate;
   
   @Value("spring.rabbitmq.exchange")
   private String exchange;
   
   @Value("spring.rabbitmq.routingkey")
   private String routingKey;
   
   public void produceMsg(String msg){
      amqpTemplate.convertAndSend(exchange, routingKey, msg);
      System.out.println("Send msg = " + msg);
   }
}