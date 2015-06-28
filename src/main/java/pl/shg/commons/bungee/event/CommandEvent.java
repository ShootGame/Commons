/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.bungee.event;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Cancellable;
import net.md_5.bungee.api.plugin.Event;

/**
 *
 * @author Aleksander
 */
public class CommandEvent extends Event implements Cancellable {
    private boolean cancel = false;
    private final String command;
    private final CommandSender sender;
    
    public CommandEvent(String command, CommandSender sender) {
        this.command = command;
        this.sender = sender;
    }
    
    @Override
    public boolean isCancelled() {
        return this.cancel;
    }
    
    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }
    
    public String getCommand() {
        return this.command;
    }
    
    public CommandSender getSender() {
        return this.sender;
    }
}
