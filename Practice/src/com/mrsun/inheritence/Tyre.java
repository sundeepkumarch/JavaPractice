/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrsun.inheritence;

/**
 *
 * @author sundechi
 */
public class Tyre {

    public void front() throws RuntimeException {
        System.out.println("Tire");
    }

    public void front(long a) {
        System.out.println("Radial Tire with long");
    }
}

class RadialTyre extends Tyre {

    public void front() {
        System.out.println("Radial Tire");
    }

    public void front(int a) throws RuntimeException {
        System.out.println("Radial Tire with int");
    }
}

class Test {

    public static void main(String[] args) {
        Tyre t = new RadialTyre();
        int a = 10;
        t.front(a);
        
        System.out.println("This is just a test");
         Tyre t1 = new RadialTyre();
         Tyre t2 = new Tyre();
         RadialTyre r = new RadialTyre();
 
//         System.out.println(Tyre instanceof t2);      //Line 1
         System.out.println(t2 instanceof RadialTyre);        //Line 2
//         System.out.println(Tyre instanceof r);        //Line 3
         System.out.println(r instanceof RadialTyre);   //Line 4 
    }
}
