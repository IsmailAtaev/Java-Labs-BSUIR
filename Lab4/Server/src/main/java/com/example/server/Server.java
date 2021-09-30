package com.example.server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Server extends Thread{

    float sum1 = 0;
    float sum2 = 0;
    public static void main(String[] args) throws IOException, InterruptedException {
        new Server();
    }
    public Server() throws IOException, InterruptedException {
        work();
    }

    private void work () throws IOException, InterruptedException {
        DatagramSocket ds = new DatagramSocket(1122);
        byte[] rd = new byte[1024];
        DatagramPacket dp = new DatagramPacket(rd, rd.length);
        ds.receive(dp);
        String msg = new String(rd, 0, dp.getLength());
        String[] arr = msg.split(" ");
        int a = Integer.valueOf(arr[0]);
        int b = Integer.valueOf(arr[1]);
        int c = Integer.valueOf(arr[2]);
        System.out.println(msg);


        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int n = a; n <= b; n++) {
                    sum1 += (float) (n*(n-1.0));
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int n = b; n <= c; n++) {
                    sum2 += (float) 1.0/(n+1.0);//вычисления
                }
            }
        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(" 1 "  + sum1 + " \t 2 " + sum2 );
        float res = sum1 -sum2;
        msg = String.valueOf(Float.valueOf(res));

        try{
            File file =  new File("file1.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file,true);
            writer.write("A=" + a + " B=" + b + " C=" + c +
                    " Result=" + msg + "\n");

            writer.flush();
            writer.close();

        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        InetAddress ip = dp.getAddress();
        byte[] sd = new byte[1024];
        sd = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(sd, sd.length, ip, dp.getPort());
        ds.send(packet);


    }

}
