/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.server;

/**
 *
 * @author Aleksander
 */
public enum Audience {
    /**
     * Public server - everyone can join
     * Shown on the signs and in the picker
     */
    PUBLIC(0, false),
    
    /**
     * Premium server - only 'shootgame.premium' permission can join
     * Shown on the signs and in the picker
     */
    PREMIUM(1, false),
    
    /**
     * Staff server - only 'shootgame.staff' permission can join
     * Shown only in the command
     */
    STAFF(2, false),
    
    /**
     * Dedicated server - only specifited player(s) and 'shootgame.staff' permission can join
     * Shown only in the command
     */
    DEDICATED(3, true),
    ;
    
    private final int id;
    private final Whitelist whitelist;
    
    private Audience(int id, boolean whitelist) {
        this.id = id;
        
        if (whitelist) {
            this.whitelist = new Whitelist();
        } else {
            this.whitelist = null;
        }
    }
    
    public int getID() {
        return this.id;
    }
    
    public Whitelist getWhitelist() {
        return this.whitelist;
    }
    
    public boolean hasWhitelist() {
        return this.whitelist != null;
    }
    
    public static String asString(Audience audience) {
        String whitelist = "0";
        if (audience.hasWhitelist()) {
            whitelist = audience.getWhitelist().toString();
        }
        
        return audience.name() + ":" + whitelist;
    }
}
