/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.bungee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import pl.shg.commons.users.BungeeUser;

/**
 *
 * @author Aleksander
 */
public class UserUtils {
    private static final Map<UUID, BungeeUser> online = new HashMap<>();
    
    public static Collection<BungeeUser> getOnline() {
        return UserUtils.online.values();
    }
    
    public static BungeeUser getUser(ProxiedPlayer bungee) {
        if (!UserUtils.online.containsKey(bungee.getUniqueId())) {
            // create a new temporary user
            return new BungeeUser(bungee);
        }
        
        return UserUtils.online.get(bungee.getUniqueId());
    }
    
    /*public class Listeners implements Listener {
        @EventHandler(priority = EventPriority.MONITOR)
        public void register(PlayerJoinEvent e) {
            BungeeUser user = UserUtils.getUser(e.getPlayer());
            UserUtils.online.put(user.getID(), user);
            
            this.callConnectEvent(user);
        }
        
        @EventHandler(priority = EventPriority.MONITOR)
        public void unregister(PlayerQuitEvent e) {
            this.callDisconnectEvent(UserUtils.getUser(e.getPlayer()));
            
            UserUtils.online.remove(e.getPlayer().getUniqueId());
        }
        
        private void callConnectEvent(BukkitUser user) {
            ProxyServer.getInstance().getPluginManager().callEvent(new UserConnectEvent(user));
        }
        
        private void callDisconnectEvent(BukkitUser event) {
            Bukkit.getPluginManager().callEvent(new UserDisconnectEvent(event));
        }
    }*/
}
