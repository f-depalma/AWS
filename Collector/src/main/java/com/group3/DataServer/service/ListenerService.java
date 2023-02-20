package com.group3.DataServer.service;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.DirectRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.AbstractMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListenerService {

    @Autowired
    private RabbitListenerEndpointRegistry listenerEndpointRegistry;


    private List<String> consumers = new ArrayList<>();

    public void addListener(String queue) {
        if (!consumers.contains(queue)) {
            consumers.add(queue);
            ((AbstractMessageListenerContainer) this.listenerEndpointRegistry.getListenerContainer("listener"))
                    .addQueueNames(queue);

            System.out.println("Received a message with the new queue name: " + queue);

        }
    }
}
