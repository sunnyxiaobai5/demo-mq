package com.sunnyxiaobai5.demo.rabbitmq.spring.work;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = {"${haixue.mq.orderGoodsRecordQueueName}"})
public class MessageReceiver {

    public void onMessag(Message message) {
        System.out.println(message);
    }
}
