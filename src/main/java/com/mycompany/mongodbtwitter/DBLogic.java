/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mongodbtwitter;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;
import java.util.ArrayList;
import java.util.Arrays;



/**
 *
 * @author florenthaxha
 */
public class DBLogic {
    private final DBCollection collection = new DBconnector().getCollection();
       
    public long getTotalUsers(){
        return collection.distinct("user").size();
    }
    
    public Iterable<DBObject> getTop10Mentioners(){
        // top 10 users that mention other users
        Iterable<DBObject> cs = collection.aggregate(Arrays.asList(
            new BasicDBObject("$match", new BasicDBObject("text", new BasicDBObject("$regex", "(?<=^|(?<=[^a-zA-Z0-9-_\\\\.]))@([A-Za-z]+[A-Za-z0-9_]+)"))),
            new BasicDBObject("$group", new BasicDBObject("_id", "$user").append("count", new BasicDBObject("$sum", 1))),
            new BasicDBObject("$sort", new BasicDBObject("count", -1)),
            new BasicDBObject("$limit",10)
        )).results();
        
        return cs;
    }
    
    public Iterable<DBObject> getTop5Mentioned(){
        // top 5 users that are mentioned
        Iterable<DBObject> cs = collection.aggregate(Arrays.asList(
            new BasicDBObject("$match", new BasicDBObject("text", new BasicDBObject("$regex", "(?<=^|(?<=[^a-zA-Z0-9-_\\\\.]))@([A-Za-z]+[A-Za-z0-9_]+)"))),    
            new BasicDBObject("$project", new BasicDBObject("user", "$user").append("texts", new BasicDBObject("$split", Arrays.asList("$text", " ")))),
            new BasicDBObject("$unwind", "$texts"),
            new BasicDBObject("$match", new BasicDBObject("texts", new BasicDBObject("$regex", "(?<=^|(?<=[^a-zA-Z0-9-_\\\\.]))@([A-Za-z]+[A-Za-z0-9_]+)"))),
            new BasicDBObject("$group", new BasicDBObject("_id", "$texts").append("count", new BasicDBObject("$sum", 1))),
            new BasicDBObject("$sort", new BasicDBObject("count", -1)),
            new BasicDBObject("$limit", 10)
        )).results();
        
        return cs;        
    }
    
    public Iterable<DBObject> getTop10MostActive(){
        // top 10 active user
        Iterable<DBObject> cs = collection.aggregate(Arrays.asList(
                new BasicDBObject("$group", new BasicDBObject("_id", "$user").append("count", new BasicDBObject("$sum", 1))),
                new BasicDBObject("$sort", new BasicDBObject("count", -1)),
                new BasicDBObject("$limit", 10)
        )).results();
        
        return cs;
        
    }
    
    public Iterable<DBObject> getTop5Grumpy(){
        // top 5 negative users
        Iterable<DBObject> cs = collection.aggregate(Arrays.asList(
                new BasicDBObject("$match", new BasicDBObject("polarity", 0)),
                new BasicDBObject("$group", new BasicDBObject("_id", "$user").append("count", new BasicDBObject("$sum", 1))),
                new BasicDBObject("$sort", new BasicDBObject("count", -1)),
                new BasicDBObject("$limit", 5)
        )).results();
        
        return cs;
    }
    
    public Iterable<DBObject> getTop5Happy(){
        // top 5 positive users
        Iterable<DBObject> cs = collection.aggregate(Arrays.asList(
                new BasicDBObject("$match", new BasicDBObject("polarity", 4)),
                new BasicDBObject("$group", new BasicDBObject("_id", "$user").append("count", new BasicDBObject("$sum", 1))),
                new BasicDBObject("$sort", new BasicDBObject("count", -1)),
                new BasicDBObject("$limit",5)
        )).results();
        
        return cs;
    }
}
