package com.sunnyxiaobai5.demo.rabbitmq.java.tutorial2;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Worker {

    private static final String HOST = "rabbitmq.elapse.com";

    private static final String QUEUE_NAME = "queue-tutorial2";

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();

        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setHost(HOST);

        Connection connection = factory.newConnection();

        final Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                    byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                System.out.println("receive message:" + message);
                try {
                    doWork(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    channel.basicAck(envelope.getDeliveryTag(), false);
                    System.out.println("finish message:" + message);
                }
            }
        };

        boolean autoAck = false;

        channel.basicQos(1);

        channel.basicConsume(QUEUE_NAME, autoAck, consumer);
    }

    private static void doWork(String message) throws InterruptedException {
        for (char ch : message.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000);
            }
        }
        System.out.println("handle message:" + message);
    }
}
