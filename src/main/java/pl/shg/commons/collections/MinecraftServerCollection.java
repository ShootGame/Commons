/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.collections;

import pl.shg.commons.field.ItemField;
import pl.shg.commons.mongo.DataField;

/**
 * Sub-collection for the Minecraft servers
 * @author Aleksander
 */
public class MinecraftServerCollection extends ServerCollection {
    /**
     * Icon for displaying this server in the server picker inventory
     */
    @DataField(type = ItemField.class)
    public static final String ICON = "icon";
}
