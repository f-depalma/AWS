package com.group3.DataServer.repository;

import com.group3.DataServer.model.SensorData;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.stereotype.Repository;

@Repository
public class SensorDataRepository {

    private MongoOperations mongoOperations;

    @Autowired
    public SensorDataRepository(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public void insert(SensorData data) {
        this.mongoOperations.insert(data, data.getName());
    }
}
