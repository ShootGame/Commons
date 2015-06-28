/*
 * Copyright (C) 2015 TheMolkaPL - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Aleksander Jagiełło <themolkapl@gmail.com>, 2015
 */
package pl.shg.commons.extended;

import pl.shg.commons.translations.SimpleWord;

/**
 *
 * @author Aleksander
 */
public class BooleanUtils extends org.apache.commons.lang3.BooleanUtils {
    public static SimpleWord toWord(boolean bool, SimpleWord trueWord, SimpleWord falseWord) {
        if (bool) {
            return trueWord;
        } else {
            return falseWord;
        }
    }
    
    public static SimpleWord toWordOnOff(boolean bool) {
        return toWord(bool, SimpleWord.ON, SimpleWord.OFF);
    }
    
    public static SimpleWord toWordTrueFalse(boolean bool) {
        return toWord(bool, SimpleWord.TRUE, SimpleWord.FALSE);
    }
    
    public static SimpleWord toWordYesNo(boolean bool) {
        return toWord(bool, SimpleWord.YES, SimpleWord.NO);
    }
}
