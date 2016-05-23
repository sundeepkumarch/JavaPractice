package com.mrsun.multithreading;

/**
 *
 * @author sundechi
 */
public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        //PrintTables
        PrintTables table2 = new PrintTables(2,true);
        PrintTables table3 = new PrintTables(3,false);
        Thread t1 = new Thread(table2);
        Thread t2 = new Thread(table3);
        t1.start();
//        t1.join();
        t2.start();
        
    }

}
