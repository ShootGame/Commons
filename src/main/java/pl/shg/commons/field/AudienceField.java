/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.field;

import pl.shg.commons.server.Audience;

/**
 *
 * @author Aleksander
 */
public class AudienceField extends CollectionField {
    private Audience audience;
    
    public AudienceField(Audience audience) {
        this.audience = audience;
    }
    
    @Override
    public String toString() {
        return String.valueOf(Audience.asString(this.getAudience()));
    }
    
    public Audience getAudience() {
        return this.audience;
    }
    
    public void setAudience(Audience audience) {
        this.audience = audience;
    }
}
