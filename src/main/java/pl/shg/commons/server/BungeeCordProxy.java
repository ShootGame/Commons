/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2014
 */
package pl.shg.commons.server;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import pl.shg.commons.bukkit.UserUtils;
import pl.shg.commons.translations.LangMessage;

/**
 *
 * @author Aleksander
 */
public class BungeeCordProxy implements IProxiedServer {
    public static final LangMessage CONNECTING = new LangMessage("commons.bungee.connecting");
    private final Plugin plugin;
    
    public BungeeCordProxy(Plugin plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public void connect(Player player, TargetServer server) {
        ByteArrayOutputStream array = new ByteArrayOutputStream();
        DataOutputStream output = new DataOutputStream(array);
        
        player.sendMessage(ChatColor.YELLOW + CONNECTING.getUserMessage(UserUtils.getUser(player), ChatColor.AQUA + server.getName() + ChatColor.YELLOW));
        try {
            output.writeUTF("Connect");
            output.writeUTF(server.getID());
        } catch (IOException ex) {
            
        }
        
        player.sendPluginMessage(this.plugin, "BungeeCord", array.toByteArray());
    }
}
