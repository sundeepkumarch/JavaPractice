package com.mrsun.multithreading;

/**
 *
 * @author sundeep
 */
public class TwoTableThread implements Runnable {

    PrintTables p;

    public TwoTableThread(PrintTables p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            p.twoTable(i);
        }
    }
}
