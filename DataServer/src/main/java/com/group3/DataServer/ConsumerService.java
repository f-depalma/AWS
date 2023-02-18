package com.group3.DataServer;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Service
public class ConsumerService {

    private List<Consumer> consumers = new ArrayList<>();

    public void addConsumer(String queue) {
        Consumer consumer = new Consumer(queue);

        try {
            consumer.subscribeToQueue();
        } catch (TimeoutException | IOException e) {
            e.printStackTrace();
        } finally {
            consumers.add(consumer);
        }
    }
}
