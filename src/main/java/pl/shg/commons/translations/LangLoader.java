/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.translations;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Aleksander
 */
public abstract class LangLoader extends File {
    private final Map<String, String> messages = new HashMap<>();
    
    public LangLoader(String pathname) throws IOException {
        super(pathname);
    }
    
    public void addMessage(String key, String message) {
        this.messages.put(key.toLowerCase(), message);
    }
    
    public Map<String, String> getMessages() {
        return this.messages;
    }
    
    public abstract void load();
}
