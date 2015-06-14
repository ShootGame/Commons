/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.field;

import java.util.Objects;

/**
 *
 * @author Aleksander
 */
public abstract class CollectionField {
    @Override
    public boolean equals(Object obj) {
        return this.toString().equals(obj.toString());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.toString());
    }
    
    @Override
    public abstract String toString();
}
