package com.myThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lab2Main {
    public static void main(String[] args) {
       GlwThread thread = new GlwThread();
       thread.start();
    }
}

class GlwThread extends Thread {
    int cargo = 10;
    MyThread myThread1;
    MyThread myThread2;
    MyThread myThread3;
    List list = Collections.synchronizedList(new ArrayList<>());

    public GlwThread() {
        this.myThread1 = new MyThread("one");
        this.myThread2 = new MyThread("two");
        this.myThread3 = new MyThread("three");
        list.add(myThread1);
        list.add(myThread2);
        list.add(myThread3);
    }

    @Override
    public void run() {
        while (true) {
            MyThread myThread;
            if (cargo > 1) {

                myThread = (MyThread) list.get(0);
                list.remove(0);
                sleeping(); // выгрузка товара 3 секунды
                cargo -= myThread.getVolumeCargo();
                myThread.start();
                try {
                    myThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               /* sleeping();
                cargo -= myThread1.getVolumeCargo();
                System.out.println(" i am cargo = " + cargo);

                sleeping();
                cargo -= myThread2.getVolumeCargo();
                System.out.println(" i am cargo = " + cargo);

                sleeping();
                cargo -= myThread3.getVolumeCargo();
                System.out.println(" i am cargo = " + cargo);*/

            } else {
                break;
            }
            list.add(myThread);
        }

    }

    private void sleeping() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
