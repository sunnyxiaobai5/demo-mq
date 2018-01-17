package com.sunnyxiaobai5.demo.rabbitmq.spring.work;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        com.sunnyxiaobai5.demo.rabbitmq.spring.work.Message message =
                new com.sunnyxiaobai5.demo.rabbitmq.spring.work.Message();
        message.setCustomerId(1L);
        message.setGoodsId(1L);
    }
}
