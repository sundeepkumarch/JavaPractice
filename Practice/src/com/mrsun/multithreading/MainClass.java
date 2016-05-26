package com.mrsun.multithreading;

/**
 *
 * @author sundechi
 */
public class MainClass {

    public static void main(String[] args) throws InterruptedException {

        PrintTables t = new PrintTables();

        TwoTableThread t1 = new TwoTableThread(t);
        ThreeTableThread t2 = new ThreeTableThread(t);

        Thread thread1 = new Thread(t1, "TwoTableThread");
        Thread thread2 = new Thread(t2, "ThreeTableThread");

        thread1.start();
        thread2.start();
    }

}
