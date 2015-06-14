/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2014
 */
package pl.shg.commons.settings;

/**
 *
 * @author Aleksander
 */
public class Setting {
    private final String name;
    private final PlayerSettingDefinition definition;
    
    public Setting(String name, PlayerSettingDefinition definition) {
        this.name = name.toLowerCase();
        this.definition = definition;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Setting) {
            return this.getName().equals(((Setting) obj).getName());
        }
        return false;
    }
    
    public String getName() {
        return this.name;
    }
    
    public PlayerSettingDefinition getDefinition() {
        return this.definition;
    }
}
