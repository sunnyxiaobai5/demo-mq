package com.sunnyxiaobai5.demo.rabbitmq.spring.work;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    private MQProperties mqProperties;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 1000, initialDelay = 0)
    public void send() {
        CustomerMessage customerMessage = new CustomerMessage();
        customerMessage.setCustomerId(1L);
        customerMessage.setGoodsId(1L);

        rabbitTemplate.convertAndSend(mqProperties.getHxExchangeName(),
                mqProperties.getOrderGoodsRecordRoutingKey(), customerMessage);
    }
}
