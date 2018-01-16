package com.sunnyxiaobai5.demo.rabbitmq.spring.tutorial1;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "spring-queue-tutorial1")
public class Tut1Receiver {

    @RabbitHandler
    public void receive(String message) {
        System.out.println(message);
    }
}
