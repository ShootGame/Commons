/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.bukkit;

import java.io.File;
import java.util.Collection;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.EventExecutor;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.UnknownDependencyException;

/**
 *
 * @author Aleksander
 */
public class HackyPluginManager implements PluginManager {
    private static final SimplePluginManager manager = (SimplePluginManager) Bukkit.getPluginManager();
    
    @Override
    public void registerInterface(Class<? extends PluginLoader> type) throws IllegalArgumentException {
        getPluginManager().registerInterface(type);
    }
    
    @Override
    public Plugin getPlugin(String string) {
        return getPluginManager().getPlugin(string);
    }
    
    @Override
    public Plugin[] getPlugins() {
        return getPluginManager().getPlugins();
    }
    
    @Override
    public boolean isPluginEnabled(String string) {
        return getPluginManager().isPluginEnabled(string);
    }
    
    @Override
    public boolean isPluginEnabled(Plugin plugin) {
        return getPluginManager().isPluginEnabled(plugin);
    }
    
    @Override
    public Plugin loadPlugin(File file) throws InvalidPluginException, InvalidDescriptionException, UnknownDependencyException {
        return getPluginManager().loadPlugin(file);
    }
    
    @Override
    public Plugin[] loadPlugins(File file) {
        return getPluginManager().loadPlugins(file);
    }
    
    @Override
    public void disablePlugins() {
        getPluginManager().disablePlugins();
    }
    
    @Override
    public void clearPlugins() {
        getPluginManager().clearPlugins();
    }
    
    @Override
    public void callEvent(Event event) throws IllegalStateException {
        EventDebugger.handleDebug(event);
        getPluginManager().callEvent(event);
    }
    
    @Override
    public void registerEvents(Listener ll, Plugin plugin) {
        getPluginManager().registerEvents(ll, plugin);
    }
    
    @Override
    public void registerEvent(Class<? extends Event> type, Listener ll, EventPriority ep, EventExecutor ee, Plugin plugin) {
        getPluginManager().registerEvent(type, ll, ep, ee, plugin);
    }
    
    @Override
    public void registerEvent(Class<? extends Event> type, Listener ll, EventPriority ep, EventExecutor ee, Plugin plugin, boolean bln) {
        getPluginManager().registerEvent(type, ll, ep, ee, plugin, bln);
    }
    
    @Override
    public void enablePlugin(Plugin plugin) {
        getPluginManager().enablePlugin(plugin);
    }
    
    @Override
    public void disablePlugin(Plugin plugin) {
        getPluginManager().disablePlugin(plugin);
    }
    
    @Override
    public Permission getPermission(String string) {
        return getPluginManager().getPermission(string);
    }
    
    @Override
    public void addPermission(Permission prmsn) {
        getPluginManager().addPermission(prmsn);
    }
    
    @Override
    public void removePermission(Permission prmsn) {
        getPluginManager().removePermission(prmsn);
    }
    
    @Override
    public void removePermission(String string) {
        getPluginManager().removePermission(string);
    }
    
    @Override
    public Set<Permission> getDefaultPermissions(boolean bln) {
        return getPluginManager().getDefaultPermissions(bln);
    }
    
    @Override
    public void recalculatePermissionDefaults(Permission prmsn) {
        getPluginManager().recalculatePermissionDefaults(prmsn);
    }
    
    @Override
    public void subscribeToPermission(String string, Permissible prmsbl) {
        getPluginManager().subscribeToPermission(string, prmsbl);
    }
    
    @Override
    public void unsubscribeFromPermission(String string, Permissible prmsbl) {
        getPluginManager().unsubscribeFromPermission(string, prmsbl);
    }
    
    @Override
    public Set<Permissible> getPermissionSubscriptions(String string) {
        return getPluginManager().getPermissionSubscriptions(string);
    }
    
    @Override
    public void subscribeToDefaultPerms(boolean bln, Permissible prmsbl) {
        getPluginManager().subscribeToDefaultPerms(bln, prmsbl);
    }
    
    @Override
    public void unsubscribeFromDefaultPerms(boolean bln, Permissible prmsbl) {
        getPluginManager().unsubscribeFromDefaultPerms(bln, prmsbl);
    }
    
    @Override
    public Set<Permissible> getDefaultPermSubscriptions(boolean bln) {
        return getPluginManager().getDefaultPermSubscriptions(bln);
    }
    
    @Override
    public Set<Permission> getPermissions() {
        return getPluginManager().getPermissions();
    }
    
    @Override
    public boolean useTimings() {
        return getPluginManager().useTimings();
    }
    
    public static SimplePluginManager getPluginManager() {
        return manager;
    }
    
    @Override
    public Collection<? extends tc.oc.minecraft.api.plugin.Plugin> getAllPlugins() {
        return getPluginManager().getAllPlugins();
    }
    
    @Override
    public void registerListener(tc.oc.minecraft.api.plugin.Plugin plugin, tc.oc.minecraft.api.event.Listener ll) {
        getPluginManager().registerListener(plugin, ll);
    }
    
    @Override
    public void unregisterListener(tc.oc.minecraft.api.event.Listener ll) {
        getPluginManager().unregisterListener(ll);
    }
    
    @Override
    public void unregisterListeners(tc.oc.minecraft.api.plugin.Plugin plugin) {
        getPluginManager().unregisterListeners(plugin);
    }
}
