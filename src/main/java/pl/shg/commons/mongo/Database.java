/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoDatabase;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aleksander
 */
public class Database {
    private static final Map<Class<? extends Helper>, Helper> helpers = new HashMap<>();
    
    public static Helper getHelper(Class<? extends Helper> helper) {
        if (!helpers.containsKey(helper)) {
            try {
                helpers.put(helper, helper.newInstance());
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return helpers.get(helper);
    }
    
    public static void initializeMongo(String uri, String database) {
        MongoClient client = createClient(uri);
        MongoDatabase mongoDatabase = client.getDatabase(uri);
        new Mongo(client, mongoDatabase);
    }
    
    public static void initializeServers(String uri, String database, String collection) {
        MongoClient client = createClient(uri);
        MongoDatabase mongoDatabase = client.getDatabase(uri);
        new ServersBase(client, mongoDatabase, mongoDatabase.getCollection(collection));
    }
    
    private static MongoClient createClient(String uri) {
        return MongoClients.create(new ConnectionString(uri));
    }
}
