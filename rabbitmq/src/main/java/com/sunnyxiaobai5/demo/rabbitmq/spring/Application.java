package com.sunnyxiaobai5.demo.rabbitmq.spring;

import com.sunnyxiaobai5.demo.rabbitmq.spring.tutorial1.Tut1Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application {

    @Value("${tutorial.client.duration:0}")
    private int duration;

    @Autowired
    private ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Profile("usage_message")
    @Bean
    public CommandLineRunner usage() {
        return new CommandLineRunner() {

            @Override
            public void run(String... arg0) throws Exception {
                System.out.println("This app uses Spring Profiles to control its behavior.\n");
                System.out.println(
                        "Sample usage: java -jar rabbit-tutorials.jar --spring.profiles.active=hello-world,sender");
            }
        };
    }

    @Profile("!usage_message")
    @Bean
    public CommandLineRunner tutorial1() {
        return args -> {
            System.out.println("Ready ... running for " + duration + "ms");
            Thread.sleep(duration);
            ctx.close();
        };
    }
}
