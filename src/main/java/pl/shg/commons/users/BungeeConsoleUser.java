/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.users;

import java.util.logging.Level;
import net.md_5.bungee.api.ProxyServer;

/**
 *
 * @author Aleksander
 */
public class BungeeConsoleUser extends ConsoleUser {
    @Override
    public void sendMessage(String message) {
        ProxyServer.getInstance().getLogger().log(Level.INFO, message);
    }
}
