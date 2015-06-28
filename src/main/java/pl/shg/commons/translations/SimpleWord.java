/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.translations;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.bukkit.entity.Player;
import pl.shg.commons.users.BukkitConsoleUser;
import pl.shg.commons.users.BungeeConsoleUser;
import pl.shg.commons.users.LocalUser;

/**
 *
 * @author Aleksander
 */
public enum SimpleWord {
    FALSE("false"),
    NO("no"),
    OFF("off"),
    ON("on"),
    TRUE("true"),
    YES("yes"),
    ;
    
    private final LangMessage message;
    
    private SimpleWord(String key) {
        this.message = new LangMessage(getFullKey(key));
    }
    
    public String bukkit(org.bukkit.command.CommandSender sender, Object... params) {
        if (sender instanceof Player) {
            return get(pl.shg.commons.bukkit.UserUtils.getUser((Player) sender), params);
        } else {
            return get(new BukkitConsoleUser(), params);
        }
    }
    
    public String bungee(net.md_5.bungee.api.CommandSender sender, Object... params) {
        if (sender instanceof ProxiedPlayer) {
            return get(pl.shg.commons.bungee.UserUtils.getUser((ProxiedPlayer) sender), params);
        } else {
            return get(new BungeeConsoleUser(), params);
        }
    }
    
    public String get(LocalUser user, Object... params) {
        return this.getMessage().getUserMessage(user, params);
    }
    
    public String getFullKey() {
        return getFullKey(this.getKey());
    }
    
    public String getKey() {
        return this.getMessage().getKey();
    }
    
    public LangMessage getMessage() {
        return this.message;
    }
    
    public static String getFullKey(String key) {
        return getSoftwareName() + "." + key;
    }
    
    public static String getSoftwareName() {
        return "simple";
    }
}
