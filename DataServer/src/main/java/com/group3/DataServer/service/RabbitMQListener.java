package com.group3.DataServer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    @RabbitListener(id="listener")
    public void receiveMessage(String message) {
        System.out.println("Consuming Message - " + message);
    }

}