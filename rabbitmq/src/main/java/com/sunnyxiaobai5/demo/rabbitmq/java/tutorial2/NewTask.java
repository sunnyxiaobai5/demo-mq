package com.sunnyxiaobai5.demo.rabbitmq.java.tutorial2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class NewTask {

    private static final String HOST = "rabbitmq.elapse.com";

    private static final String QUEUE_NAME = "queue-tutorial2";

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();

        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setHost(HOST);

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(">");

            String message = scanner.nextLine();

            if (message.equals("exit")) {
                return;
            }

            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
        }
    }
}
