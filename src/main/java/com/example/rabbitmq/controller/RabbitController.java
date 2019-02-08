package com.example.rabbitmq.controller;

import com.example.rabbitmq.pub.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {

    @Autowired
    private Publisher publisher;

    @GetMapping("/send")
    public String send(@RequestParam("msg") String msg) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " : " + msg);
            publisher.publish(msg);
        }

        return "Success!";
    }
}
