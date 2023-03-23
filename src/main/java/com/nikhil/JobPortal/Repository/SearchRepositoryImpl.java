package com.nikhil.JobPortal.Repository;

import java.util.ArrayList;
import java.util.Arrays;

import com.mongodb.client.MongoClient;
import com.nikhil.JobPortal.Model.Post;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.bson.Document;
import com.mongodb.client.AggregateIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;
/*
 * Requires the MongoDB Java Driver.
 * https://mongodb.github.io/mongo-java-driver
 */

@Component
public class SearchRepositoryImpl implements SearchRepository {

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Post> findByText(String text) {

        final List<Post>  posts = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("JobPost");
        MongoCollection<Document> collection = database.getCollection("Jobs");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("tech", "desc", "profile")))),
                new Document("$sort",
                        new Document("exp", 1L))));

        result.forEach(doc -> posts.add(converter.read(Post.class,doc)));

        return posts;
    }
}
