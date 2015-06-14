/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.mongo;

import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;

/**
 *
 * @author Aleksander
 */
public class ServersBase {
    public static final String URI = "mongodb://127.0.0.1:27017";
    public static final String DATABASE = "servers";
    public static final String COLLECTION = "public-servers";
    
    private static MongoClient mongo;
    private static MongoDatabase database;
    private static MongoCollection collection;
    
    public ServersBase(MongoClient mongo, MongoDatabase database, MongoCollection collection) {
        if (ServersBase.mongo != null) {
            throw new UnsupportedOperationException("");
        }
        
        ServersBase.mongo = mongo;
        ServersBase.database = database;
        ServersBase.collection = collection;
    }
    
    public static MongoClient getMongo() {
        return mongo;
    }
    
    public static MongoDatabase getDatabase() {
        return database;
    }
    
    public static MongoCollection getServers() {
        return collection;
    }
}
