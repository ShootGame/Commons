/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.field;

import java.net.InetSocketAddress;

/**
 *
 * @author Aleksander
 */
public class InetSocketAddressField extends CollectionField {
    private InetSocketAddress address;
    
    public InetSocketAddressField(InetSocketAddress address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        String port = "";
        if (this.getAddress().getPort() >= 0) {
            port = String.valueOf(this.getAddress().getPort());
        }
        
        return String.valueOf(this.getAddress().getAddress().getHostAddress() + port);
    }
    
    public InetSocketAddress getAddress() {
        return this.address;
    }
    
    public void setAddress(InetSocketAddress address) {
        this.address = address;
    }
}
