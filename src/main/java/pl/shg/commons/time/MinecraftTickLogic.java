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
public class MinecraftTickLogic {
    private long ticks;
    
    public MinecraftTickLogic(long ticks) {
        this.ticks = ticks;
    }
    
    public long getMillis() {
        return getTicks() * 50;
    }
    
    public long getTicks() {
        return this.ticks;
    }
    
    public long getSeconds() {
        return this.getTicks() / 20L;
    }
    
    public long getMinutes() {
        return this.getSeconds() / 60L;
    }
    
    public long getHours() {
        return this.getMinutes() / 60L;
    }
    
    public void setTicks(long ticks) {
        this.ticks = ticks;
    }
    
    public static MinecraftTickLogic fromMillis(long millis) {
        return new MinecraftTickLogic(millis / 50);
    }
    
    public static MinecraftTickLogic fromTicks(long ticks) {
        return new MinecraftTickLogic(ticks);
    }
    
    public static MinecraftTickLogic fromSeconds(long seconds) {
        return fromTicks(seconds * 20L);
    }
    
    public static MinecraftTickLogic fromMinutes(long minutes) {
        return fromSeconds(minutes * 60L);
    }
    
    public static MinecraftTickLogic fromHours(long hours) {
        return fromMinutes(hours * 60L);
    }
}
