/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mongodbtwitter;


import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.DB;
import org.bson.Document;

/**
 *
 * @author florenthaxha
 */
public class DBconnector {
    
    private final MongoClientURI connstr;
    private final MongoClient mongoClient;
    private final DB db;
    private final DBCollection collection;
    

    public DBconnector() {
        this.connstr = new MongoClientURI("mongodb://localhost:27017");
        this.mongoClient = new MongoClient(this.connstr);
        this.db = mongoClient.getDB("social_net");
        this.collection = db.getCollection("tweets");
    }

    public DB getDb() {
        return db;
    }
    
    public DBCollection getCollection(){
        return collection;
    }

    
    
}
