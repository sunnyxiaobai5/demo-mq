package com.sunnyxiaobai5.demo.rabbitmq.spring.tutorial5;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class Tut5Receiver {

    @RabbitListener(queues = "#{queue.name}")
    public void receive(String in) {
        System.out.println(in);
    }

}
