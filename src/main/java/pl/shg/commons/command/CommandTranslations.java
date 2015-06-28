/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.command;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bukkit.entity.Player;
import pl.shg.commons.translations.LangMessage;
import pl.shg.commons.users.BukkitConsoleUser;
import pl.shg.commons.users.BungeeConsoleUser;
import pl.shg.commons.users.LocalUser;

/**
 *
 * @author Aleksander
 */
public class CommandTranslations {
    public static final LangMessage ERROR = new LangMessage(getCode("error"));
    public static final LangMessage NUMBER = new LangMessage(getCode("number"));
    public static final LangMessage PERMISSION = new LangMessage(getCode("permission"));
    public static final LangMessage SEVERE = new LangMessage(getCode("severe"));
    
    public static LocalUser getBukkitUser(org.bukkit.command.CommandSender sender) {
        if (sender instanceof Player) {
            return pl.shg.commons.bukkit.UserUtils.getUser((Player) sender);
        } else {
            return new BukkitConsoleUser();
        }
    }
    
    public static LocalUser getBungeeUser(net.md_5.bungee.api.CommandSender sender) {
        if (sender instanceof ProxiedPlayer) {
            return pl.shg.commons.bungee.UserUtils.getUser((ProxiedPlayer) sender);
        } else {
            return new BungeeConsoleUser();
        }
    }
    
    private static String getCode(String key) {
        return "commons.command." + key;
    }
}
