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

public class MyThread extends Thread {
    private final Logger logger = LogManager.getLogger(MyThread.class.getName());
    private int countFlight = 0;
    private int timeFlight = 3000; // millisecond
    private int volumeCargo = 2;
    public Thread thread;

    public MyThread(String name) {
        thread = new Thread(name);
    }

    @Override
    public void run() {
        this.timeZoneCargo();
        this.countFlight++;
    }

    private synchronized void timeZoneCargo() {
        try {
            System.out.println("i sleep 3 second\nthread name =  " + thread.getName());
            this.thread.sleep(timeFlight);
            System.out.println("i am ready thread " + thread.getName());
        } catch (InterruptedException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }

    public int getCountFlight() {
        return countFlight;
    }

    public void setCountFlight(int countFlight) {
        this.countFlight = countFlight;
    }

    public int getTimeFlight() {
        return timeFlight;
    }

    public void setTimeFlight(int timeFlight) {
        this.timeFlight = timeFlight;
    }

    public int getVolumeCargo() {
        return volumeCargo;
    }

    public void setVolumeCargo(int volumeCargo) {
        this.volumeCargo = volumeCargo;
    }


}
