package com.group3.DataServer;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMQConnection {

    private static final String USERNAME = "guest";
    private static final String PASSWORD = "guest";
    private static final String VIRTUAL_HOST = "/";
    private static final String HOST_NAME = "localhost";
    private static final int PORT_NUMBER = 5672;

    private static Connection connection = null;
    private static Channel channel = null;



    public static Connection connect() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(USERNAME);
        factory.setPassword(PASSWORD);
        factory.setVirtualHost(VIRTUAL_HOST);
        factory.setHost(HOST_NAME);
        factory.setPort(PORT_NUMBER);
        connection = factory.newConnection();
        return connection;
    }

    public static Channel getChannel() throws IOException, TimeoutException {
        if (connection == null) connect();
        channel = connection.createChannel();
        return channel;
    }

    public static void closeConnection() throws IOException, TimeoutException {
        channel.close();
        connection.close();
    }
}
