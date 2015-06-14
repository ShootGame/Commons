/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.mongo;

import com.mongodb.async.client.MongoCollection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aleksander
 */
public abstract class Helper {
    private static AbstractCollection instance;
    
    public AbstractCollection getCollection() {
        try {
            if (instance == null) {
                instance = this.getCollectionClass().newInstance();
            }
            
            return instance;
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public abstract Class<? extends AbstractCollection> getCollectionClass();
    
    public MongoCollection getMongo() {
        return this.getCollection().getMongo();
    }
}
