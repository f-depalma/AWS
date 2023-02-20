package com.group3.DataServer.controller;

import com.group3.DataServer.service.ListenerService;
import com.group3.DataServer.model.QueueData;
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
    ListenerService listenerService;


    @PostMapping
    public ResponseEntity saveUser(@Validated @RequestBody QueueData queue) {
        System.out.println("New queue added");
        listenerService.addListener(queue.getName());
        return ResponseEntity.ok().build();
    }
}