/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.users;

import java.util.UUID;
import net.md_5.bungee.api.ChatColor;

/**
 *
 * @author Aleksander
 */
public class Console {
    private static String name;
    public static final UUID ID = UUID.fromString("b59ea471-ee8e-46e3-87cd-b871fe3512a9"); // console's UUID
    
    public static String getColoredName() {
        return ChatColor.GOLD.toString() + ChatColor.ITALIC + getName() + ChatColor.RESET;
    }
    
    public static String getName() {
        return name;
    }
    
    public void setName(String name) {
        Console.name = name;
    }
}
