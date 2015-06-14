/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.mongo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Aleksander
 */
public class Base {
    private static final Map<String, AbstractCollection> collections = new HashMap<>();
    
    public static AbstractCollection byClass(Class clazz) {
        for (AbstractCollection collection : getCollections()) {
            if (collection.getClass().equals(clazz)) {
                return collection;
            }
        }
        return null;
    }
    
    public static AbstractCollection byName(String name) {
        return collections.get(name);
    }
    
    public static void registerSimple(Class collection) {
        try {
            DataCollection dataAnnotation = getCollectionAnnotation(collection);
            AbstractCollection base = new SimpleCollection();
            
            for (Field field : collection.getFields()) {
                DataField data = getMongoField(field);
                
                if (data != null) {
                    
                }
            }
            
            collections.put(dataAnnotation.id(), base);
        } catch (Throwable ex) {
            
        }
    }
    
    public static Collection<AbstractCollection> getCollections() {
        return collections.values();
    }
    
    private static DataCollection getCollectionAnnotation(Class clazz) {
        Annotation annotation = clazz.getDeclaredAnnotation(DataCollection.class);
        if (annotation != null) {
            return (DataCollection) annotation;
        } else {
            throw new IllegalArgumentException("clazz must be @DataCollection annotated");
        }
    }
    
    private static DataField getMongoField(Field field) {
        int mod = field.getModifiers();
        boolean modifier = Modifier.isPublic(mod) && Modifier.isStatic(mod) && Modifier.isFinal(mod);
        
        Annotation annotation = field.getDeclaredAnnotation(DataField.class);
        if (modifier && annotation != null) {
            return (DataField) annotation;
        }
        
        return null;
    }
}
