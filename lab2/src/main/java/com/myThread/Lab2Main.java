package com.myThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Lab2Main {

    public static void main(String[] args) throws InterruptedException {

        MyThread.ton = 10;

        Object locker = new Object();
        MyThread thread1 = new MyThread("one", 300, 2,locker);
        MyThread thread2 = new MyThread("two", 200, 3,locker);
        MyThread thread3 = new MyThread("three", 100, 1,locker);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();


        System.out.println("count ton = " + MyThread.ton);
    }
}