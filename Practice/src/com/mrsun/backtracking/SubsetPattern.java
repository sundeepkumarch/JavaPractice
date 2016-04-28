package com.mrsun.backtracking;

import java.util.Scanner;

/**
 *
 * @author sundechi
 */
public class SubsetPattern {

    public static void main(String[] args) {
        Scanner is = new Scanner(System.in);
        String input = is.next();
        String soFar = "";
        recSubsets(soFar, input);
    }

    static void recSubsets(String soFar, String rest) {
        if (rest.length() == 0) {
            System.out.println(soFar);
        } else {
            String p1 = soFar + rest.charAt(0);
            String p2 = rest.substring(1);
            System.out.println("--> "+p1 + " : " + p2);
            recSubsets(p1, p2);
            recSubsets(soFar, p2);
        }
    }
}
