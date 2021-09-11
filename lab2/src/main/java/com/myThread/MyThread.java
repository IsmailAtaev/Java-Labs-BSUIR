package com.myThread;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ataev Ismayyl
 * @implNote Runnable
 *  поток это наш работник данном, случае это грузовик
 * 1. счетчик для рейсов
 * 2. грузовместимость потока или грузовика (1,5).(3.4).(5.1)
 * 3. timer for sleep() (30 min, 45 min, 40 min)
 *
 * */

public class MyThread extends Thread {

    private final Logger logger = LogManager.getLogger(MyThread.class.getName());
    private int countFlight = 0;
    private int timeFlight = 0; // millisecond
    private int volumeCargo = 0;
    static public Integer ton;
    public Thread thread;

    public MyThread(String name, int timeFlight, int volumeCargo, Integer ton) {
        thread = new Thread(name);
        this.timeFlight = timeFlight;
        this.volumeCargo = volumeCargo;
        this.ton = ton;
    }

    @Override
    public void run() {
        this.sleeping();
        System.out.println("Count of race = " + this.countFlight);
        System.out.println("----------------------------" );
    }

    private synchronized void sleeping(){
        while (ton > volumeCargo) {
            System.out.println("Thread = " + this.thread.getName()+ " start ");
            System.out.println("Ton after = " + this.ton);
            //this.ton.addAndGet(-volumeCargo);
            this.ton -= volumeCargo;
            try {
                Thread.sleep(timeFlight);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.countFlight++;
            System.out.println("Ton before = " + this.ton);
            System.out.println("Thread " + this.thread.getName()+ " finish ");
        }
    }
}
