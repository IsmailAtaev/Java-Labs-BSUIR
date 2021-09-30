package com.example.client;

public final class Check {
    public static int checkInt(String value) {
        if (value.equals(" ")) {
            throw new IllegalArgumentException(" incorrect value class final Check");
        }
        return Integer.valueOf(value);
    }

    public static float checkFloat(String value) {
        value.trim();
        if (value.equals(" ")) {
            throw new IllegalArgumentException(" incorrect value class final Check");
        }
        return Float.valueOf(value);
    }
}
