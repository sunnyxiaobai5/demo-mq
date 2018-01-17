package com.sunnyxiaobai5.demo.rabbitmq.spring.tutorial5;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"tut5", "topics"})
@Configuration
public class Tut5Config {

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("hxexchange");
    }

    @Profile("receiver")
    private static class ReceiverConfig {

        @Bean
        public Tut5Receiver receiver() {
            return new Tut5Receiver();
        }

        @Bean
        public Queue queue() {
            return new AnonymousQueue();
        }

        @Bean
        public Binding binding(TopicExchange exchange, Queue queue) {
            return BindingBuilder.bind(queue).to(exchange).with("hx.order.ordergoodsrecord");
        }
    }

    @Profile("sender")
    @Bean
    public Tut5Sender sender() {
        return new Tut5Sender();
    }
}
