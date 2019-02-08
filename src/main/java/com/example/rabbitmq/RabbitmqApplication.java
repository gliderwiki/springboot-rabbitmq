package com.example.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Date;

@SpringBootApplication
@RabbitListener(queues = "test")
@EnableScheduling
public class RabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqApplication.class, args);
    }


    @Bean
    public Send sender() {
        return new Send();
    }

    @Bean
    public Queue testQueue() {
        return new Queue("test");
    }

    @RabbitHandler
    public void process(@Payload String arg) {
        System.out.println(new Date() + ": " + arg);
    }
}

