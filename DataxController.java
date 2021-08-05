package com.MongoJava.controller;
import java.util.*;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.web.bind.annotation.*;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;

@RestController
public class DataxController {

    MongoClient mongoClient = new MongoClient( "w3.training5.modak.com" , 27017 );
    MongoDatabase db = mongoClient.getDatabase("tr_java_2021");
    MongoCollection<Document> collection= db.getCollection("mt3048us2");


    @GetMapping("/")
    public String helloWorld(){
        return "Connection Successful";
    }

    @PostMapping("/county")
    public List County(@RequestParam String s) {
        List<Document> list= new ArrayList<>();
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("county",s);
        MongoCursor<Document> cursor2 = collection.find(searchQuery).iterator();
        while (cursor2.hasNext()) {
            list.add(cursor2.next());

        }


        return list;

    }

    @PostMapping("/state")
    public List State(@RequestParam String s) {
        List<Document> list= new ArrayList<>();
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("state",s);
        MongoCursor<Document> cursor2 = collection.find(searchQuery).iterator();
        while (cursor2.hasNext()) {
            list.add(cursor2.next());

        }
        return list;

    }






}
