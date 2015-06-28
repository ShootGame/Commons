/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.translations;

/**
 *
 * @author Aleksander
 */
public enum LangProperty {
    CODE("code"),
    FULL("full"),
    ;
    
    private final String key;
    
    private LangProperty(String key) {
        this.key = key;
    }
    
    public String getFullKey() {
        return Translations.PROPERTY_KEY + "." + this.getKey();
    }
    
    public String getKey() {
        return this.key;
    }
}
