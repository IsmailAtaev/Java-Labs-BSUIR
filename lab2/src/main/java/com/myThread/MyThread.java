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
    private static int timeGeneric = 0;
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
        System.out.println("----------------------------");
        System.out.println("Count of race = " + this.countFlight + " Thread --> " + thread.getName());
        System.out.println("----------------------------");
    }

    private void sleeping() {
        System.out.println("Start thread --> " + thread.getName());
        while (true) {
            synchronized (locker) {
                if (ton > 1)
                    this.ton -= volumeCargo;
                else
                    break;
                threadSleep(2000);
                timeGeneric += 2000;
            }
            threadSleep(timeFlight);
            this.countFlight++;
        }
        System.out.println("Finish thread --> " + thread.getName());
    }

    /**
     * @param time
     * @throws InterruptedException,Exception
     */
    private void threadSleep(int time) {
        try {
            timeGeneric += time;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            logger.log(Level.ERROR.ERROR, e.getMessage());
        } catch (Exception e) {
            logger.log(Level.ERROR.ERROR, e.getMessage());
        }
    }

    public static int getTimeGeneric() {
        return timeGeneric / 1000;
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

    public static int getTon() {
        return ton;
    }

    public static void setTon(int ton) {
        MyThread.ton = ton;
    }

    public static void setTimeGeneric(int timeGeneric) {
        MyThread.timeGeneric = timeGeneric;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public Object getLocker() {
        return locker;
    }

    public void setLocker(Object locker) {
        this.locker = locker;
    }
}
