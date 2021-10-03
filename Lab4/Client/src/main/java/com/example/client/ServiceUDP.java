package com.example.client;

import java.io.IOException;
import java.net.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * @author Ataev Ismayyl (issyataew@gmail.com)
 */

public class ServiceUDP {

    private final Logger logger = LogManager.getLogger(ServiceUDP.class.getName());

    private DatagramSocket datagramSocket;

    private DatagramPacket dP;

    private ABCResult abcResult;

    private ConnectDate connectDate;



    public ServiceUDP() throws SocketException {
        this.datagramSocket = new DatagramSocket();
    }

    public ServiceUDP(ConnectDate connectDate, ABCResult abcResult) throws SocketException {
        this.connectDate = connectDate;
        this.abcResult = abcResult;
        this.datagramSocket = new DatagramSocket();
    }

    /**
     * @throws IllegalArgumentException
     * @return port
     * check port
     * */
    public static int checkPort(String port) {
        if (port.equals("")) {
            throw new IllegalArgumentException("incorrect input port class Connect method checkPort() ");
        }
        return Integer.valueOf(port);
    }

    public void connectClient( byte[] date,InetAddress ip, int port) {
        dP = new DatagramPacket(date, date.length, ip, port);
    }

    public void sendPackageClient() throws IOException {
        datagramSocket.send(dP);
    }


    /**
     * @throws UnknownHostException,IOException
     * */
    public void serviceSend() {
        try {

            byte[] sd = new byte[1024];
            String valueABC = String.valueOf(abcResult.getA()) + " ";
            valueABC += String.valueOf(abcResult.getB()) + " ";
            valueABC += String.valueOf(abcResult.getC());
            sd = valueABC.getBytes();

            connectClient(sd, ConnectDate.getThisLocalHost(), connectDate.getPort());
            sendPackageClient();

        } catch (UnknownHostException e) {
            logger.log(Level.ERROR, e.getMessage());
        } catch (IOException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }

    /**
     * date processing
     * @return str(date)
     * */
    public String serviceReceive() throws IOException {
        byte[] rd = new byte[1024];
        DatagramPacket packet = new DatagramPacket(rd, rd.length);
        datagramSocket.receive(packet);
        String str = new String(rd, 0, packet.getLength());
        return str;
    }





}
