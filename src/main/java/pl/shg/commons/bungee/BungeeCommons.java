/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.bungee;

import java.io.File;
import java.util.logging.Level;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import pl.shg.commons.bukkit.UserUtils;
import pl.shg.commons.bukkit.UserUtils.Listeners;
import pl.shg.commons.translations.XMLLangLoader;

/**
 *
 * @author Aleksander
 */
public class BungeeCommons {
    public static void initialize(Plugin plugin, File lang) {
        // listeners
        //ProxyServer.getInstance().getPluginManager().registerListener(plugin, new UserUtils().new Listeners());
        
        // translations
        plugin.getLogger().log(Level.INFO, "Ladowanie plikow tlumaczen z {0}...", lang.getAbsolutePath());
        XMLLangLoader.loadXMLTranslations(lang);
    }
}
