/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.field;

import pl.shg.commons.util.Items;

/**
 *
 * @author Aleksander
 */
public class ItemField extends CollectionField {
    private Items.Item item;
    
    public ItemField(Items.Item item) {
        this.item = item;
    }
    
    @Override
    public String toString() {
        return Items.asString(this.getItem());
    }
    
    public Items.Item getItem() {
        return this.item;
    }
    
    public void setItem(Items.Item item) {
        this.item = item;
    }
}
