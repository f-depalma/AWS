package com.group3.DataServer.repository;

import com.group3.DataServer.model.QueueData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class CollectionRepository {

    @Autowired
    private MongoTemplate mongodb;

    public void insertOne(QueueData data) {
        mongodb.insert(data, data.getName());
    }
}
