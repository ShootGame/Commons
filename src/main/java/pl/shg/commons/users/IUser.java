/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.users;

import java.util.Locale;

/**
 *
 * @author Aleksander
 */
public interface IUser {
    ChatStatus getChatStatus();
    
    Locale getLocale();
    
    void sendActionMessage(String message);
    
    void sendChatMessage(String message);
    
    void sendMessage(String message);
    
    boolean sendPacket(Object packet);
}
