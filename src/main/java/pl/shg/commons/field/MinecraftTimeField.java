/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.field;

import pl.shg.commons.time.MinecraftTickLogic;

/**
 *
 * @author Aleksander
 */
public class MinecraftTimeField extends CollectionField {
    private MinecraftTickLogic time;
    
    public MinecraftTimeField(MinecraftTickLogic time) {
        this.time = time;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.getTime().getTicks());
    }
    
    public MinecraftTickLogic getTime() {
        return this.time;
    }
    
    public void setTime(MinecraftTickLogic time) {
        this.time = time;
    }
}
