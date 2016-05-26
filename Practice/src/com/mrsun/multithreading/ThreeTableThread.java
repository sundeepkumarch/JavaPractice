package com.mrsun.multithreading;

/**
 *
 * @author sundeep
 */
public class ThreeTableThread implements Runnable {

    PrintTables p;

    public ThreeTableThread(PrintTables p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            p.threeTable(i);
        }
    }

}
