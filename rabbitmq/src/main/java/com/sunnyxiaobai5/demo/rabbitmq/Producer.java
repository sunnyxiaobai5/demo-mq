package com.sunnyxiaobai5.demo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    private static final String HOST = "rabbitmq.elapse.com";

    private static final String QUEUE_NAME = "test-queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        String message = "hello world!";

        ConnectionFactory factory = new ConnectionFactory();

        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setHost(HOST);

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

        for (int i = 0; i < 100; i++) {
            channel.basicPublish("", QUEUE_NAME, null, (message + i).getBytes());
            System.out.println("send message " + message + i);
        }

        channel.close();
        connection.close();
    }
}
