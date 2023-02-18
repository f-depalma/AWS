package com.group3.DataServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/queue")
public class QueueController {

    @Autowired
    RabbitMQConfiguration rabbitMQConfiguration;

    @Autowired
    ConsumerService consumerService;

    @PostMapping
    public ResponseEntity saveUser(@Validated @RequestBody QueueData queue) {
        //rabbitMQConfiguration.addQueue(queue.getName());
        consumerService.addConsumer(queue.getName());
        return ResponseEntity.ok().build();
    }
}