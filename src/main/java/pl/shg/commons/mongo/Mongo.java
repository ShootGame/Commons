/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.mongo;

import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoDatabase;

/**
 *
 * @author Aleksander
 */
public class Mongo {
    public static String URI = "mongodb://127.0.0.1:27017";
    public static String DATABASE = "shg";
    
    private static MongoClient mongo;
    private static MongoDatabase database;
    
    public Mongo(MongoClient mongo, MongoDatabase database) {
        if (Mongo.mongo != null) {
            throw new UnsupportedOperationException("");
        }
        
        Mongo.mongo = mongo;
        Mongo.database = database;
    }
    
    public static MongoClient getMongo() {
        return mongo;
    }
    
    public static MongoDatabase getDatabase() {
        return database;
    }
}
