package com.myThread;

/**@author Ataew Ismayyl
 * Лабараторная работа номер два.
 * */

public class Lab2Main {
    public static void main(String[] args) throws InterruptedException {

        MyThread.ton = 86;

        Object locker = new Object();
        MyThread thread1 = new MyThread("one", 300, 2,locker);
        MyThread thread2 = new MyThread("two", 100, 3,locker);
        MyThread thread3 = new MyThread("three", 100, 1,locker);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();


        System.out.println("count ton = " + MyThread.ton);
        System.out.println("Generic count time = " + MyThread.getTimeGeneric());
    }
}