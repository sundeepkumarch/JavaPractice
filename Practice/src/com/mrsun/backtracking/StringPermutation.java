package com.mrsun.backtracking;

import java.util.Scanner;

/**
 *
 * @author sundechi
 */
public class StringPermutation {

    public static void main(String[] args) {
        Scanner is = new Scanner(System.in);
        String input = is.next();
        String soFar = "";
        rec(soFar, input);
    }

    static void rec(String soFar, String rest) {
        if (rest.length() == 0) {
            System.out.println(soFar);
        } else {
            for (int i = 0; i < rest.length(); i++) {
                String remaining = rest.substring(0, i) + rest.substring(i + 1);
                rec(soFar + rest.charAt(i), remaining);
            }
        }

    }
}
