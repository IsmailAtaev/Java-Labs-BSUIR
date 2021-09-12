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
 * */

public class MyThread extends Thread {

    private final Logger logger = LogManager.getLogger(MyThread.class.getName());
    private int countFlight = 0;
    private int timeFlight = 0; // millisecond
    private int volumeCargo = 0;
    public static int ton;
    public Thread thread;
    private Object locker;

    public MyThread(String name, int timeFlight, int volumeCargo, Object locker) {
        thread = new Thread(name);
        this.timeFlight = timeFlight;
        this.volumeCargo = volumeCargo;
        this.locker = locker;

    }

    @Override
    public void run() {
        this.sleeping();
        System.out.println("Count of race = " + this.countFlight + " Thread --> " + thread.getName());
        System.out.println("----------------------------");
    }

    private void sleeping() {

        while (true) {

            synchronized (locker) {

                if (ton > 1)
                    this.ton -= volumeCargo;
                else
                    break;


                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    logger.log(Level.ERROR.ERROR, e.getMessage());
                }

            }

            try {
                Thread.sleep(timeFlight);
            } catch (InterruptedException e) {
                logger.log(Level.ERROR.ERROR, e.getMessage());
            }
            this.countFlight++;
        }
    }
}
