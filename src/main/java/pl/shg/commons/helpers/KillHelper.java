/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.helpers;

import com.mongodb.async.SingleResultCallback;
import org.bson.Document;
import pl.shg.commons.collections.KillCollection;
import pl.shg.commons.field.UserField;
import pl.shg.commons.mongo.AbstractCollection;
import pl.shg.commons.mongo.Helper;
import pl.shg.commons.mongo.VoidResultCallback;
import pl.shg.commons.users.LocalUser;

/**
 *
 * @author Aleksander
 */
public class KillHelper extends Helper {
    @Override
    public Class<? extends AbstractCollection> getCollectionClass() {
        return KillCollection.class;
    }
    
    public void addKill(LocalUser player, LocalUser killer) {
        Document document = new Document();
        document.put("player", new UserField(player).toString());
        document.put("killer", new UserField(killer).toString());
        
        this.getMongo().insertOne(document, new VoidResultCallback());
    }
}
