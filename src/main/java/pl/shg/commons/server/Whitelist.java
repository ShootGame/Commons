/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.server;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Aleksander
 */
public class Whitelist {
    private final List<UUID> container;
    
    public Whitelist() {
        this.container = new ArrayList<>();
    }
    
    public boolean add(UUID value) {
        return this.container.add(value);
    }
    
    public List<UUID> getContainer() {
        return this.container;
    }
    
    public boolean remove(UUID value) {
        return this.container.remove(value);
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder().append("[");
        for (int i = 0; i < this.getContainer().size(); i++) {
            if (i != 0) {
                builder.append(",");
            }
            builder.append(this.getContainer().get(i).toString());
        }
        return builder.append("]").toString();
    }
}
