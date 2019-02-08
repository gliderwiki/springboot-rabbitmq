package com.example.rabbitmq.pub;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    @Autowired
    private AmqpTemplate amqpTemplate;


    @Value("${custom.rabbitmq.exchange}")
    private String exchange;

    @Value("${custom.rabbitmq.routingkey}")
    private String routingKey;


    public void produce(String message) {
        amqpTemplate.convertAndSend(exchange, routingKey, message);
        System.out.println("Send message = " + message);
    }
}
