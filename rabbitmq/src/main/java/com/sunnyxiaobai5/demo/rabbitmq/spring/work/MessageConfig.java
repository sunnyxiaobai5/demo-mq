package com.sunnyxiaobai5.demo.rabbitmq.spring.work;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("work")
@Configuration
public class MessageConfig {

    @Autowired
    private MessageProperties messageProperties;

    @Bean
    public TopicExchange hxExchange() {
        return new TopicExchange(messageProperties.getHxExchangeName(), true, false);
    }

    @Bean
    public Queue orderGoodsRecordQueue() {
        return new Queue(messageProperties.getOrderGoodsRecordQueueName(), true);
    }

    @Bean
    public Binding orderGoodsRecordQueueBinding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with(messageProperties.getOrderGoodsRecordQueueRoutingKey());
    }

}
