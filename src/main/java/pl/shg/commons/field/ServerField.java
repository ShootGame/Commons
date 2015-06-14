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
public class ServerField extends CollectionField {
    private Server server;
    
    public ServerField(Server server) {
        this.server = server;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.getServer().getID());
    }
    
    public Server getServer() {
        return this.server;
    }
    
    public void setServer(Server server) {
        this.server = server;
    }
}
