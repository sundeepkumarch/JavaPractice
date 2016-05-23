package com.mrsun.multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sundechi
 */
public class PrintTables implements Runnable {

    int N;
    boolean check;
//    private final Object object = new Object();

    public PrintTables(int n, boolean check) {
        this.N = n;
        this.check = check;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            synchronized (this) {
                System.out.println("checking");
                if (check) {
                    System.out.println(N + " x " + i + " = " + i * N);
                    check = false;
                    try {
                        System.out.println("waiting");
                        wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PrintTables.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    System.out.println(N + " x " + i + " = " + i * N);
                    check = true;
                    notify();
                }
                

            }
        }
        System.out.println("--------");
    }

}
