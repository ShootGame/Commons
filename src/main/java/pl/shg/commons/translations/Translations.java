/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.translations;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 *
 * @author Aleksander
 */
public class Translations {
    public static final Locale DEFAULT = Locale.US; // en_US
    private static final Map<String, Message> messages = new HashMap<>();
    
    public static void addMessage(Message message) {
        messages.put(message.getKey(), message);
    }
    
    public static Message getMessage(String key) {
        key = key.toLowerCase();
        
        if (!messages.containsKey(key)) {
            messages.put(key, new Message(key));
        }
        
        return messages.get(key);
    }
    
    public static Collection<Message> getMessages() {
        return messages.values();
    }
}
