/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.users;

import java.util.Locale;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.apache.commons.lang.LocaleUtils;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import pl.shg.commons.util.Messages;

/**
 *
 * @author Aleksander
 */
public class BukkitUser extends LocalUser {
    private final CraftPlayer bukkit;
    
    private final Locale locale;
    
    public BukkitUser(Player bukkit) {
        super(bukkit.getUniqueId());
        this.bukkit = (CraftPlayer) bukkit;
        
        this.locale = LocaleUtils.toLocale(this.getNMS().locale);
    }
    
    @Override
    public ChatStatus getChatStatus() {
        switch (this.getNMS().getChatFlags()) { // returns "bV" variable
            case FULL: return ChatStatus.ENABLED;
            case HIDDEN: return ChatStatus.HIDDEN;
            case SYSTEM: return ChatStatus.COMMANDS_ONLY;
            default: throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
    @Override
    public Locale getLocale() {
        return this.locale;
    }
    
    @Override
    public void sendActionMessage(String message) {
        Messages.sendAction(this.getBukkit(), message);
    }
    
    @Override
    public void sendChatMessage(String message) {
        Messages.sendChat(this.getBukkit(), message);
    }
    
    @Override
    public void sendMessage(String message) {
        Messages.sendMessage(this.getBukkit(), message);
    }
    
    @Override
    public boolean sendPacket(Object packet) {
        if (!(packet instanceof Packet)) {
            return false;
        }
        
        try {
            this.getConnection().sendPacket((Packet) packet);
            return true;
        } catch (Throwable ex) {
            return false;
        }
    }
    
    public CraftPlayer getBukkit() {
        return this.bukkit;
    }
    
    public PlayerConnection getConnection() {
        return this.getNMS().playerConnection;
    }
    
    public final EntityPlayer getNMS() {
        return this.getBukkit().getHandle();
    }
}
