/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.mongo;

import java.lang.annotation.Annotation;
import pl.shg.commons.field.ServerField;
import pl.shg.commons.field.UnixTimeField;

/**
 * A simple collection class for all collections stored in the database
 * @author Aleksander
 */
public class SimpleCollection extends AbstractCollection {
    /**
     * Name of server that this software is running on
     */
    @DataField(type = ServerField.class)
    public static final String SERVER = "server";
    
    /**
     * Unix's time for saving the current server-time
     */
    @DataField(type = UnixTimeField.class)
    public static final String TIME = "time";
    
    @Override
    public String getCollectionName() {
        Annotation annotation = this.getClass().getDeclaredAnnotation(DataCollection.class);
        if (annotation != null) {
            return ((DataCollection) annotation).id();
        }
        
        return null;
    }
}
