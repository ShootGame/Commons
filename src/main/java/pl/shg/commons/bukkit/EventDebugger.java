/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.bukkit;

import java.lang.reflect.Field;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

/**
 *
 * @author Aleksander
 */
public class EventDebugger implements Listener {
    private static EventDebugger debugger;
    
    public static void handleDebug(Event event) {
        String log = "%s is called %s (%s).";
        
        String channel;
        if (event.isAsynchronous()) {
            channel = "asynchronous";
        } else {
            channel = "synchronous";
        }
        
        System.out.println(String.format(log, event.getEventName(), channel, event.toString()));
    }
    
    public static void register() {
        if (debugger == null) {
            debugger = new EventDebugger();
        }
        
        EventDebugger.inject();
    }
    
    public static void unregister() {
        HandlerList.unregisterAll(debugger);
        
        EventDebugger.unject();
    }
    
    private static void inject() {
        try {
            Server server = Bukkit.getServer();
            Field field = server.getClass().getDeclaredField("pluginManager");
            field.setAccessible(true);
            field.set(server, new HackyPluginManager());
        } catch (Throwable ex) {
            Bukkit.getLogger().log(Level.SEVERE, "Could not inject the plugin manager object.", ex);
        }
    }
    
    private static void unject() {
        try {
            Server server = Bukkit.getServer();
            Field field = server.getClass().getDeclaredField("pluginManager");
            field.setAccessible(true);
            field.set(server, HackyPluginManager.getPluginManager());
        } catch (Throwable ex) {
            Bukkit.getLogger().log(Level.SEVERE, "Could not unject the plugin manager object.", ex);
        }
    }
}
