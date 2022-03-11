package com.tmb.automation.common;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoDB {

    private  com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

    public List connectDB(String clientUrl, String databaseName, String collectionName, BasicDBObject query, String sortsBy, int limit) {

        MongoClientURI uri = new MongoClientURI(clientUrl);
        MongoClient mongo_client = new MongoClient(uri);
        MongoDatabase db = mongo_client.getDatabase(databaseName);
        MongoCollection<Document> coll = db.getCollection(collectionName);
        List<String> listData = new ArrayList<String>();
        FindIterable<Document> data = null;

        if (!query.isEmpty() &&  !sortsBy.isEmpty() && limit > 0) {
            data = coll.find(query).sort(Sorts.descending(sortsBy)).limit(limit);
        } else if (query.isEmpty() && query.isEmpty() && limit > 0) {
            data = coll.find().limit(limit);
        } else if (!query.isEmpty() && query.isEmpty() && limit > 0) {
            data = coll.find(query).limit(limit);
        } else {
            data = coll.find();
        }

        MongoCursor<Document> cursor = data.iterator();
        try {
            while (cursor.hasNext()) {
                listData.add(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        return listData;
    }
}

