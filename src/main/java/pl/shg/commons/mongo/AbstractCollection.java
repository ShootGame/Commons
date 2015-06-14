/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.mongo;

import com.mongodb.async.client.MongoCollection;

/**
 *
 * @author Aleksander
 */
public abstract class AbstractCollection {
    public abstract String getCollectionName();
    
    public MongoCollection getMongo() {
        return Mongo.getDatabase().getCollection(this.getCollectionName());
    }
}
