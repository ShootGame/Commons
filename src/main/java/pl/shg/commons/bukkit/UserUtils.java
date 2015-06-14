/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.bukkit;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.shg.commons.bukkit.event.UserConnectEvent;
import pl.shg.commons.bukkit.event.UserDisconnectEvent;
import pl.shg.commons.users.BukkitUser;

/**
 *
 * @author Aleksander
 */
public class UserUtils {
    private static final Map<UUID, BukkitUser> online = new HashMap<>();
    
    public static Collection<BukkitUser> getOnline() {
        return UserUtils.online.values();
    }
    
    public static BukkitUser getUser(Player bukkit) {
        if (!UserUtils.online.containsKey(bukkit.getUniqueId())) {
            // create a new temporary user
            return new BukkitUser(bukkit);
        }
        
        return UserUtils.online.get(bukkit.getUniqueId());
    }
    
    public class Listeners implements Listener {
        @EventHandler(priority = EventPriority.MONITOR)
        public void register(PlayerJoinEvent e) {
            BukkitUser user = UserUtils.getUser(e.getPlayer());
            UserUtils.online.put(user.getID(), user);
            
            this.callConnectEvent(user);
        }
        
        @EventHandler(priority = EventPriority.MONITOR)
        public void unregister(PlayerQuitEvent e) {
            this.callDisconnectEvent(UserUtils.getUser(e.getPlayer()));
            
            UserUtils.online.remove(e.getPlayer().getUniqueId());
        }
        
        private void callConnectEvent(BukkitUser user) {
            Bukkit.getPluginManager().callEvent(new UserConnectEvent(user));
        }
        
        private void callDisconnectEvent(BukkitUser event) {
            Bukkit.getPluginManager().callEvent(new UserDisconnectEvent(event));
        }
    }
}
