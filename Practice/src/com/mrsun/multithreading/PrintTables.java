package com.mrsun.multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sundechi
 */
public class PrintTables {

    boolean check = false;

    public synchronized void twoTable(int i) {
        if (check) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(PrintTables.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(2 + " x " + i + " = " + i * 2);
        check = true;
        notify();
    }

    public synchronized void threeTable(int i) {
        if (!check) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(PrintTables.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(3 + " x " + i + " = " + i * 3);
        check = false;
        notify();
    }

}
