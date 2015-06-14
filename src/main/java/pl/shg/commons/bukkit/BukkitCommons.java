/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.bukkit;

import java.io.File;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import pl.shg.commons.translations.XMLLangLoader;

/**
 *
 * @author Aleksander
 */
public class BukkitCommons {
    public static void initialize(Plugin plugin, File lang) {
        // listeners
        Bukkit.getPluginManager().registerEvents(new UserUtils().new Listeners(), plugin);
        
        // translations
        plugin.getLogger().log(Level.INFO, "Ladowanie plikow tlumaczen z {0}...", lang.getAbsolutePath());
        XMLLangLoader.loadXMLTranslations(lang);
    }
}
