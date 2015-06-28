/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.command;

import com.sk89q.bukkit.util.BukkitCommandsManager;
import com.sk89q.bukkit.util.CommandsManagerRegistration;
import com.sk89q.minecraft.util.commands.CommandException;
import com.sk89q.minecraft.util.commands.CommandPermissionsException;
import com.sk89q.minecraft.util.commands.CommandUsageException;
import com.sk89q.minecraft.util.commands.CommandsManager;
import com.sk89q.minecraft.util.commands.WrappedCommandException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import pl.shg.commons.translations.LangMessage;

/**
 *
 * @author Aleksander
 */
public class BukkitCommandBase {
    private static final CommandsManager<CommandSender> manager = new BukkitCommandsManager();
    private static final Map<Plugin, CommandsManagerRegistration> registrations = new HashMap<>();
    
    public static CommandsManager<CommandSender> getManager() {
        return manager;
    }
    
    public static CommandsManagerRegistration getRegistration(Plugin plugin) {
        return registrations.getOrDefault(plugin, new CommandsManagerRegistration(plugin, getManager()));
    }
    
    public static Collection<CommandsManagerRegistration> getRegistrations() {
        return registrations.values();
    }
    
    public static boolean isRegistered(CommandsManagerRegistration registration) {
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
    
    public static class Executor implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            try {
                getManager().execute(command.getName(), args, sender, sender);
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
            return true;
        }
        
        private String getMessage(CommandSender sender, LangMessage message, Object... params) {
            return message.getUserMessage(CommandTranslations.getBukkitUser(sender), params);
        }
    }
}
