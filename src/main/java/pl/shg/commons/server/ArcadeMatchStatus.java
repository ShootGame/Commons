/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.server;

/**
 *
 * @author Aleksander
 */
public enum ArcadeMatchStatus {
    RESTARTING(0),
    STARTING(1),
    RUNNING(2),
    CYCLING(3),
    ;
    
    private final int id;
    
    private ArcadeMatchStatus(int id) {
        this.id = id;
    }
    
    public int getID() {
        return this.id;
    }
}
