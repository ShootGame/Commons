/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.translations;

import java.text.MessageFormat;
import pl.shg.commons.users.LocalUser;

/**
 *
 * @author Aleksander
 */
public class LangMessage {
    private final String key;
    
    public LangMessage(String key) {
        this.key = key;
    }
    
    public String getKey() {
        return this.key;
    }
    
    public String getRawMessage(LocalUser user) {
        return Translations.getMessage(this.getKey()).get(user.getLocale());
    }
    
    public String getUserMessage(LocalUser user, Object... params) {
        return MessageFormat.format(this.getRawMessage(user), this.getParams(params));
    }
    
    public void send(LocalUser user, Object... params) {
        user.sendMessage(this.getUserMessage(user, this.getParams(params)));
    }
    
    public void sendAction(LocalUser user, Object... params) {
        user.sendActionMessage(this.getUserMessage(user, this.getParams(params)));
    }
    
    public void sendChat(LocalUser user, Object... params) {
        user.sendChatMessage(this.getUserMessage(user, this.getParams(params)));
    }
    
    private Object[] getParams(Object... params) {
        if (params != null) {
            return params;
        } else {
            return new Object[0];
        }
    }
}
