package com.io;

import com.myThread.MyThread;

import java.util.Scanner;

public class Module {
    private Scanner in = new Scanner(System.in);
    private MyThread myThread1;
    private MyThread myThread2;
    private MyThread myThread3;
    Object locker = new Object();

    public void init() {

        System.out.print("Enter ton = ");
        MyThread.ton = in.nextInt();

        System.out.print("Enter volume cargo1 integer =\t");
        int cargo1 = in.nextInt();
        this.myThread1 = new MyThread("one", 2000, cargo1, this.locker);

        System.out.print("Enter volume cargo2 integer =\t");
        int cargo2 = in.nextInt();
        this.myThread2 = new MyThread("two", 3000, cargo2, this.locker);


        System.out.print("Enter volume cargo3 integer =\t");
        int cargo3 = in.nextInt();
        this.myThread3 = new MyThread("three", 1000, cargo3, this.locker);
    }

    public void execute() {
        myThread1.start();
        myThread2.start();
        myThread3.start();
        try {
            myThread1.join();
            myThread2.join();
            myThread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void done() {
        System.out.println("count ton = " + MyThread.ton);
        System.out.println("Generic count time = " + MyThread.getTimeGeneric());
    }

    public static void main(String[] args) {
        Module module = new Module();
        module.init();
        module.execute();
        module.done();
    }
}
