/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.users;

import java.util.UUID;

/**
 *
 * @author Aleksander
 */
public abstract class LocalUser implements IUser {
    private final UUID id;
    
    public LocalUser(UUID id) {
        this.id = id;
    }
    
    public UUID getID() {
        return this.id;
    }
}
