/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.mongo;

import com.mongodb.async.SingleResultCallback;

/**
 *
 * @author Aleksander
 */
public class VoidResultCallback implements SingleResultCallback<Void> {
    @Override
    public void onResult(Void result, Throwable throwable) {
        System.out.println("dodano nowy dokument - " + result.toString());
    }
}
