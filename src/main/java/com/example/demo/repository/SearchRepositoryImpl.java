package com.example.demo.repository;

import com.example.demo.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository{

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Post> findByText(String text){
        final List<Post> posts = new ArrayList<>();

        MongoDatabase database = client.getDatabase("dbone");
        MongoCollection<org.bson.Document> collection = database.getCollection("classPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text", new Document("query", text).append("path", Arrays.asList("type", "desc"))))));

        result.forEach(doc -> posts.add(converter.read(Post.class, doc)));
        return posts;
    }
}
