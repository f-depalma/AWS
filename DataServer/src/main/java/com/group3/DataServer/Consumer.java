package com.group3.DataServer;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Consumer {

    private String queue;

    RabbitMQConfiguration rabbitMQService;

    public Consumer(String queue) {
        this.queue = queue;
    }

    public void subscribeToQueue() throws IOException, TimeoutException {
        boolean autoAck = false;
        Channel channel = RabbitMQConnection.getChannel();
        channel.basicConsume(queue, autoAck, "myConsumerTag",
                new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(String consumerTag,
                                               Envelope envelope,
                                               AMQP.BasicProperties properties,
                                               byte[] body)
                            throws IOException {
                        String routingKey = envelope.getRoutingKey();
                        String contentType = properties.getContentType();
                        long deliveryTag = envelope.getDeliveryTag();

                        String bodyString= new String(body, StandardCharsets.UTF_8);

                        JsonObject bodyJson = JsonParser.parseString(bodyString).getAsJsonObject();
                        System.out.println(bodyJson);
                        channel.basicAck(deliveryTag, false);
                    }
                });
    }
}
