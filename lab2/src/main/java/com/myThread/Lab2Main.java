package com.myThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Lab2Main {

    volatile static int ton = 10;

    public static void main(String[] args) throws InterruptedException {
        //AtomicInteger  ton = new AtomicInteger(86);
        MyThread thread1 = new MyThread("one", 300, 2, ton);
        MyThread thread2 = new MyThread("two", 200, 2, ton);
        MyThread thread3 = new MyThread("three", 100, 2, ton);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("count ton = " + ton);
    }
}