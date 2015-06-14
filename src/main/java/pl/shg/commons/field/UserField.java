/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.field;

import pl.shg.commons.users.LocalUser;

/**
 *
 * @author Aleksander
 */
public class UserField extends CollectionField {
    private LocalUser player;
    
    public UserField(LocalUser player) {
        this.player = player;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.getPlayer().getID().toString());
    }
    
    public LocalUser getPlayer() {
        return this.player;
    }
    
    public void setPlayer(LocalUser player) {
        this.player = player;
    }
    
    public static ConsoleUserField console() {
        return new ConsoleUserField();
    }
}
