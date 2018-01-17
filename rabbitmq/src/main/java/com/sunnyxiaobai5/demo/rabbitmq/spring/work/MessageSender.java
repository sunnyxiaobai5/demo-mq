package com.sunnyxiaobai5.demo.rabbitmq.spring.work;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    private MessageProperties messageProperties;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //    @Scheduled(fixedDelay = 1000, initialDelay = 0)
    public void send() {
        CustomerMessage message = new CustomerMessage();
        message.setCustomerId(1L);
        message.setGoodsId(1L);

        rabbitTemplate.convertAndSend(messageProperties.getHxExchangeName(), messageProperties.getOrderGoodsRecordRoutingKey(), message);
    }
}
