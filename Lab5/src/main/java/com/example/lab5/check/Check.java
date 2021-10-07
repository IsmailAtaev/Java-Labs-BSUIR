package com.example.lab5.check;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

public class Check {
    public static boolean isNumber(String number) {
        return !number.equals("") && number != null && number.matches("\\d+?");
    }

    public static boolean isString(String str) {
        return !str.equals("") && str != null;
    }

}