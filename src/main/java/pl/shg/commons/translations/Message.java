/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.translations;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Aleksander
 */
public class Message {
    public static final Message NOT_FOUND = new Message(null, "Tlumaczenie nie zostalo odnalezione.");
    
    private final String key;
    private final Locale locale;
    private final Map<Locale, String> values = new HashMap<>();
    
    public Message(String key) {
        this(key, key);
    }
    
    public Message(String key, String message) {
        this(key, Translations.DEFAULT, message);
    }
    
    public Message(String key, Locale locale, String message) {
        if (key != null) {
            this.key = key.toLowerCase();
        } else {
            this.key = null;
        }
        this.locale = locale;
        
        this.add(locale, message);
    }
    
    public final void add(Locale locale, String value) {
        this.values.put(locale, value);
    }
    
    public String get(Locale locale) {
        if (locale != null && this.values.containsKey(locale)) {
            return this.values.get(locale);
        } else {
            return this.getDefault();
        }
    }
    
    public String getDefault() {
        return this.get(this.getDefaultLocale());
    }
    
    public Locale getDefaultLocale() {
        return this.locale;
    }
    
    public String getKey() {
        return this.key;
    }
    
    public Set<Locale> getLocales() {
        return this.values.keySet();
    }
}
