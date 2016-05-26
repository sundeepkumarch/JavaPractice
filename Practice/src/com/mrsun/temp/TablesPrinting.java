package com.mrsun.temp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sundeep
 */
public class TablesPrinting {

    public static void main(String[] args) {
        Object lock = new Object();
        TwoTableThread t1 = new TwoTableThread(lock, true);
        ThreeTableThread t2 = new ThreeTableThread(lock, true);
        
        Thread twoThread = new Thread(t1);
        Thread threeThread = new Thread(t2);
        
        twoThread.start();
        threeThread.start();
        
    }

    static class TwoTableThread implements Runnable {

        final Object lock;
        boolean flag;

        public TwoTableThread(Object lock, boolean flag) {
            this.lock = lock;
            this.flag = flag;
        }

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    while (!flag) {
                        try {
                            System.out.println("EvenWaiting");
                            lock.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(TablesPrinting.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    System.out.println("2 x " + i + " = " + 2 * i);
                    flag = true;
                    lock.notify();
                }
            }
        }
    }

    static class ThreeTableThread implements Runnable {

        final Object lock;
        boolean flag;

        public ThreeTableThread(Object lock, boolean flag) {
            this.lock = lock;
            this.flag = flag;
        }

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    while (flag) {
                        try {
                            System.out.println("OddWaiting");
                            lock.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(TablesPrinting.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    System.out.println("3 x " + i + " = " + 3 * i);
                    flag = false;
                    lock.notify();
                }
            }
        }

    }
}
