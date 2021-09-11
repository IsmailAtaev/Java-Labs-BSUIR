package com.myThread;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

/**
 * @author Ataev Ismayyl
 * @implNote Runnable
 *  поток это наш работник данном, случае это грузовик
 * 1. счетчик для рейсов
 * 2. грузовместимость потока или грузовика (1,5).(3.4).(5.1)
 * 3. timer for sleep() (30 min, 45 min, 40 min)
 *
 * */

public class MyThread implements Runnable {
    private final Logger logger = LogManager.getLogger(MyThread.class.getName());
    private int countFlight = 0;
    private int timeFlight = 0; // millisecond
    private double volumeCargo = 0;
    private Thread thread;

    {
        thread = new Thread();
    }

    @Override
    public void run() {
        this.timeZoneCargo();
        this.countFlight++;
    }

    private void timeZoneCargo(){
        try {
            this.thread.sleep(timeFlight);
        } catch (InterruptedException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }
}
