package com.example.rabbitmq.sub;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Subscriber {

    @RabbitListener(queues = "${custom.rabbitmq.queue}")
    public void subscribe(String message) {
        System.out.println("Received Message = " + message);
    }
}
