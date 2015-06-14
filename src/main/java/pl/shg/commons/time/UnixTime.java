/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.time;

/**
 *
 * @author Aleksander
 */
public class UnixTime {
    private long time;
    
    public UnixTime(long time) {
        this.time = time;
    }
    
    public long getTime() {
        return this.time;
    }
    
    public void setNow() {
        this.setTime(UnixTime.now().getTime());
    }
    
    public void setTime(long time) {
        this.time = time;
    }
    
    public static UnixTime now() {
        return new UnixTime(System.currentTimeMillis());
    }
}
