/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.field;

import pl.shg.commons.time.UnixTime;

/**
 *
 * @author Aleksander
 */
public class UnixTimeField extends CollectionField {
    private UnixTime time;
    
    public UnixTimeField(UnixTime time) {
        this.time = time;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.getTime().getTime());
    }
    
    public UnixTime getTime() {
        return this.time;
    }
    
    public void setTime(UnixTime time) {
        this.time = time;
    }
}
