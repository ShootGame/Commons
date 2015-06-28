/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.users;

import java.util.logging.Level;
import org.bukkit.Bukkit;

/**
 *
 * @author Aleksander
 */
public class BukkitConsoleUser extends ConsoleUser {
    @Override
    public void sendMessage(String message) {
        Bukkit.getLogger().log(Level.INFO, message);
    }
}
