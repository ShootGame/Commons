/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.users;

import java.util.Locale;
import pl.shg.commons.translations.Translations;

/**
 *
 * @author Aleksander
 */
public abstract class ConsoleUser extends LocalUser {
    public ConsoleUser() {
        super(Console.ID);
    }
    
    @Override
    public ChatStatus getChatStatus() {
        return ChatStatus.ENABLED;
    }
    
    @Override
    public Locale getLocale() {
        return Translations.DEFAULT; // return default locale
    }
    
    @Override
    public void sendActionMessage(String message) {
        this.sendMessage("[Channel-Action] " + message);
    }
    
    @Override
    public void sendChatMessage(String message) {
        this.sendMessage("[Channel-Chat] " + message);
    }
    
    @Override
    public boolean sendPacket(Object packet) {
        throw new UnsupportedOperationException("Can not send packets to the console.");
    }
}
