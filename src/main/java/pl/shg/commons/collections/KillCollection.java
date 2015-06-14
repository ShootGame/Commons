/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.collections;

import pl.shg.commons.field.UserField;
import pl.shg.commons.mongo.DataCollection;
import pl.shg.commons.mongo.DataField;
import pl.shg.commons.mongo.SimpleCollection;

/**
 * Kills with deaths managements
 * @author Aleksander
 */
@DataCollection(id = "kill")
public class KillCollection extends SimpleCollection {
    /**
     * Player who deaths in this document
     */
    @DataField(type = UserField.class)
    public static final String PLAYER = "player";
    
    /**
     * Player who kills the player
     */
    @DataField(type = UserField.class)
    public static final String KILLER = "killer";
}
