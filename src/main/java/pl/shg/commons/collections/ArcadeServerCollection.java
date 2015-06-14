/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.collections;

import pl.shg.commons.field.MatchStatusField;
import pl.shg.commons.mongo.DataField;

/**
 * Sub-collection for the Arcade servers
 * @author Aleksander
 */
public class ArcadeServerCollection extends ServerCollection {
    /**
     * Current's map display name
     */
    @DataField(type = String.class)
    public static final String MAP_NAME = "map-name";
    
    /**
     * Status of currently playing match
     */
    @DataField(type = MatchStatusField.class)
    public static final String MATCH_STATUS = "match-status";
    
    /**
     * Amount of online players in the teams (total)
     */
    @DataField(type = Integer.class)
    public static final String TEAMS_ONLINE = "teams-online";
    
    /**
     * Slots in the teams (total)
     */
    @DataField(type = Integer.class)
    public static final String TEAMS_SIZE = "teams-size";
}
