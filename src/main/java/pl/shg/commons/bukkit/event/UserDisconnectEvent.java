/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.bukkit.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import pl.shg.commons.users.BukkitUser;

/**
 *
 * @author Aleksander
 */
public class UserDisconnectEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final BukkitUser user;
    
    public UserDisconnectEvent(BukkitUser user) {
        this.user = user;
    }
    
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    
    public static HandlerList getHandlerList() {
        return handlers;
    }
    
    public BukkitUser getUser() {
        return this.user;
    }
}
