package com.example.client;

import java.util.regex.Pattern;

/**
 * @author Ataev Ismayyl (issyataew@gmail.com)
 * class intended for check value int, float
 * class don't edited
 * */

public final class Check {

    /**
     * @throws InterruptedException
     * @return int
     * */
    public static int checkInt(String value) {
        if (value.equals(" ")) {
            throw new IllegalArgumentException(" incorrect value class final Check");
        }
        return Integer.valueOf(value);
    }

    /**
     * @throws InterruptedException
     * @return float
     * */
    public static float checkFloat(String value) {
        value.trim();
        if(!isNumeric(value)){
            System.out.println( " it is not number men ");
           // throw new IllegalArgumentException(" incorrect value class final Check");
        }
        if (value.equals(" ")) {
            throw new IllegalArgumentException(" incorrect value class final Check");
        }
        return Float.valueOf(value);
    }


    public static boolean isNumeric(String string) {
        // Checks if the provided string
        // is a numeric by applying a regular
        // expression on it.
        String regex = "[0-9]+[\\.]?[0-9]*";
        return Pattern.matches(regex, string);
    }

}
