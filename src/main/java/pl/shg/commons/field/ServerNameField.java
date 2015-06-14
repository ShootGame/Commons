/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.field;

import pl.shg.commons.server.Server;

/**
 *
 * @author Aleksander
 */
public class ServerNameField extends ServerField {
    public ServerNameField(Server server) {
        super(server);
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.getServer().getName());
    }
}
