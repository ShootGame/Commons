/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.util;

/**
 *
 * @author Aleksander
 */
public class Items {
    public static final char ID_SEPARATOR = '\u003A'; // :
    
    public static Item valueOf(String string) {
        return null;
    }
    
    public static String asString(Item item) {
        return String.valueOf(item.getID() + Character.toString(Items.ID_SEPARATOR) + item.getSubID());
    }
    
    public static class Item {
        private int id, subID;
        
        public Item(int id) {
            this(id, 0);
        }
        
        public Item(int id, int subID) {
            this.id = id;
            this.subID = subID;
        }
        
        public int getID() {
            return this.id;
        }
        
        public int getSubID() {
            return this.subID;
        }
        
        public boolean hasSubID() {
            return this.getSubID() > 0;
        }
        
        public void setID(int id) {
            this.id = id;
        }
        
        public void setSubID(int subID) {
            this.subID = subID;
        }
    }
}
