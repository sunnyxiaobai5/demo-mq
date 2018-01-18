package com.sunnyxiaobai5.demo.rabbitmq.spring.work;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class MessageReceiver {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${haixue.mq.orderGoodsRecordQueueName}", durable = "true",
                    exclusive = "false", autoDelete = "false"),
            exchange = @Exchange(value = "${haixue.mq.hxExchangeName}", type = "topic", durable = "true"),
            key = "${haixue.mq.orderGoodsRecordRoutingKey}"))
    public void onMessage(CustomerMessage message) {
        System.out.println("receive:" + message);
    }
}
