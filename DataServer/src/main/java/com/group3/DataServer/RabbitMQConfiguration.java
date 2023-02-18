package com.group3.DataServer;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RabbitMQConfiguration {

    private List<String> queues = new ArrayList<>();

    public void addQueue(String queue) {
        if (!queues.contains(queue)) {
            queues.add(queue);
            System.out.println(queue);
        }
    }
}
