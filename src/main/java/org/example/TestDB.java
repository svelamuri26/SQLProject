package org.example;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;

import java.util.List;

public class TestDB {

    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        // get database
        MongoDatabase database = mongoClient.getDatabase("crudlab");
        MongoCollection<Document> collection = database.getCollection("employees");

        // document (mongodb) <=>  table rows (mysql)
        Document employee1 = new Document("name", "John Doe")
                .append("position", "Software Engineer")
                .append("salary", 8000);
        Document employee2 = new Document("name", "Jane Smith")
                .append("position", "Data Analyst")
                .append("salary", 60000);
        Document employee3 = new Document("name", "Bob Johnson")
                .append("position", "Product Manager")
                .append("salary", 90000);

        // insert multiple documents
        InsertManyResult insertManyResult = collection.insertMany(List.of(employee1, employee2, employee3));
        System.out.println("Document inserted. " + insertManyResult.getInsertedIds());
    }
}

