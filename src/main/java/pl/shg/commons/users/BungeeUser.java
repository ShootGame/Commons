/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.users;

import java.util.Locale;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.protocol.DefinedPacket;

/**
 *
 * @author Aleksander
 */
public class BungeeUser extends LocalUser {
    private final ProxiedPlayer bungee;
    
    public BungeeUser(ProxiedPlayer bungee) {
        super(bungee.getUniqueId());
        this.bungee = bungee;
    }
    
    @Override
    public ChatStatus getChatStatus() {
        return ChatStatus.ENABLED;
    }
    
    @Override
    public Locale getLocale() {
        return this.getBungee().getLocale();
    }
    
    @Override
    public void sendActionMessage(String message) {
        this.getBungee().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
    }
    
    @Override
    public void sendChatMessage(String message) {
        this.getBungee().sendMessage(ChatMessageType.CHAT, TextComponent.fromLegacyText(message));
    }
    
    @Override
    public void sendMessage(String message) {
        this.getBungee().sendMessage(ChatMessageType.SYSTEM, TextComponent.fromLegacyText(message));
    }
    
    @Override
    public boolean sendPacket(Object packet) {
        if (!(packet instanceof DefinedPacket)) {
            return false;
        }
        
        try {
            this.getBungee().unsafe().sendPacket((DefinedPacket) packet);
            return true;
        } catch (Throwable ex) {
            return false;
        }
    }
    
    public ProxiedPlayer getBungee() {
        return this.bungee;
    }
}
