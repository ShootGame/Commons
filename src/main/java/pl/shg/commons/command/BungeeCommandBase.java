/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.command;

import com.sk89q.bungee.util.BungeeCommandsManager;
import com.sk89q.bungee.util.CommandExecutor;
import com.sk89q.bungee.util.CommandRegistration;
import com.sk89q.minecraft.util.commands.CommandException;
import com.sk89q.minecraft.util.commands.CommandPermissionsException;
import com.sk89q.minecraft.util.commands.CommandUsageException;
import com.sk89q.minecraft.util.commands.CommandsManager;
import com.sk89q.minecraft.util.commands.WrappedCommandException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import pl.shg.commons.bungee.event.CommandEvent;
import pl.shg.commons.translations.LangMessage;

/**
 *
 * @author Aleksander
 */
public class BungeeCommandBase {
    private static final CommandsManager<CommandSender> manager = new BungeeCommandsManager();
    private static final Map<Plugin, CommandRegistration> registrations = new HashMap<>();
    
    public static CommandsManager<CommandSender> getManager() {
        return manager;
    }
    
    public static CommandRegistration getRegistration(Plugin plugin) {
        return registrations.getOrDefault(plugin,
                new CommandRegistration(plugin, ProxyServer.getInstance().getPluginManager(), getManager(), new Executor()));
    }
    
    public static Collection<CommandRegistration> getRegistrations() {
        return registrations.values();
    }
    
    public static boolean isRegistered(CommandRegistration registration) {
        return registrations.containsValue(registration);
    }
    
    public static boolean isRegistered(Plugin plugin) {
        return registrations.containsKey(plugin);
    }
    
    public static void register(Plugin plugin, Class... clazz) {
        if (!isRegistered(plugin)) {
            registrations.put(plugin, getRegistration(plugin));
        }
        
        for (Class loop : clazz) {
            registrations.get(plugin).register(loop);
        }
    }
    
    public static class Executor implements CommandExecutor<CommandSender> {
        @Override
        public void onCommand(CommandSender sender, String command, String[] args) {
            try {
                CommandEvent event = new CommandEvent(command, sender);
                ProxyServer.getInstance().getPluginManager().callEvent(event);
                
                if (!event.isCancelled()) {
                    getManager().execute(command, args, sender, sender);
                }
            } catch (CommandPermissionsException ex) {
                sender.sendMessage(ChatColor.RED + this.getMessage(sender, CommandTranslations.PERMISSION));
            } catch (CommandUsageException ex) {
                if (ex.getMessage() != null) {
                    sender.sendMessage(ChatColor.RED + ex.getMessage());
                }
                sender.sendMessage(ChatColor.RED + ex.getUsage());
            } catch (WrappedCommandException ex) {
                if (ex.getCause() instanceof NumberFormatException) {
                    sender.sendMessage(ChatColor.RED + this.getMessage(sender, CommandTranslations.NUMBER));
                } else {
                    sender.sendMessage(ChatColor.RED + this.getMessage(sender, CommandTranslations.SEVERE, ex.getMessage()));
                    ex.printStackTrace();
                }
            } catch (CommandException ex) {
                sender.sendMessage(ChatColor.RED + this.getMessage(sender, CommandTranslations.ERROR, ex.getMessage()));
            }
        }
        
        private String getMessage(CommandSender sender, LangMessage message, Object... params) {
            return message.getUserMessage(CommandTranslations.getBungeeUser(sender), params);
        }
    }
}
