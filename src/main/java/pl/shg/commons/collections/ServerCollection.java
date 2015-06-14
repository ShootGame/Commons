/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.collections;

import pl.shg.commons.field.AudienceField;
import pl.shg.commons.field.InetSocketAddressField;
import pl.shg.commons.field.MinecraftTimeField;
import pl.shg.commons.field.ServerNameField;
import pl.shg.commons.field.UnixTimeField;
import pl.shg.commons.mongo.DataCollection;
import pl.shg.commons.mongo.DataField;
import pl.shg.commons.mongo.SimpleCollection;

/**
 * Network servers management
 * @author Aleksander
 */
@DataCollection(id = "server")
public class ServerCollection extends SimpleCollection {
    /**
     * Display name of this server used to represent him for players
     */
    @DataField(type = ServerNameField.class)
    public static final String NAME = "name";
    
    /**
     * Address of this server
     */
    @DataField(type = InetSocketAddressField.class)
    public static final String ADDRESS = "address";
    
    /**
     * Interval time for refreshing that server
     */
    @DataField(type = MinecraftTimeField.class)
    public static final String INTERVAL = "interval";
    
    /**
     * Last time when server was pinged (refreshed)
     * Simple check: offline = PING < UnixTime.now() - INTERVAL * 2
     */
    @DataField(type = UnixTimeField.class)
    public static final String PING = "ping";
    
    /**
     * Audience of this server
     */
    @DataField(type = AudienceField.class)
    public static final String AUDIENCE = "audience";
    
    /**
     * Type of this server as a string
     */
    @DataField(type = String.class)
    public static final String TYPE = "type";
    
    /**
     * Online players on this server
     */
    @DataField(type = Short.class)
    public static final String ONLINE = "online";
    
    /**
     * Amount of slots that can be filled by the online players
     */
    @DataField(type = Short.class)
    public static final String SLOTS = "slots";
    
    /**
     * Amount of extra slots that can be filled by the premium players
     */
    @DataField(type = Short.class)
    public static final String OVERFILL = "overfill";
    
    /**
     * Message called 'Message Of The Day' for this server
     */
    @DataField(type = String.class)
    public static final String DESCRIPTION = "description";
}
