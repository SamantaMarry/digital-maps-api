package com.digitalmaps.api.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class MongoConfiguration {

    private static final String COLLECTION_NAME = "interestPoint";
    private static final String FIELD = "location";

    private final MongoClient mongoClient;
    private final String database;

    public MongoConfiguration(MongoClient mongoClient, @Value("${spring.data.mongodb.database}") String database) {
        this.mongoClient = mongoClient;
        this.database = database;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initIndicesAfterStartup() {
        MongoDatabase db = mongoClient.getDatabase(database);
        MongoCollection<Document> interestPoint = db.getCollection(COLLECTION_NAME);
        interestPoint.createIndex(Indexes.geo2dsphere(FIELD));
    }

}
