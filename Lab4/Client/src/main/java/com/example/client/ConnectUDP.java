package com.example.client;

public class ConnectUDP {

    public static int checkPort(String port) {
        if (port.equals("")) {
            throw new IllegalArgumentException("incorrect input port class Connect method checkPort() ");
        }
        return Integer.valueOf(port);
    }


}
