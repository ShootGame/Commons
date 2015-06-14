/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.field;

import pl.shg.commons.server.ArcadeMatchStatus;

/**
 *
 * @author Aleksander
 */
public class MatchStatusField extends CollectionField {
    private ArcadeMatchStatus status;
    
    public MatchStatusField(ArcadeMatchStatus status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.getStatus().name());
    }
    
    public ArcadeMatchStatus getStatus() {
        return this.status;
    }
    
    public void setStatus(ArcadeMatchStatus status) {
        this.status = status;
    }
}
