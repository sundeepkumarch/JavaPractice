package com.mrsun.questions;

import java.util.Scanner;

/**
 * Write regexp matching strings having only letters a, but only of length which
 * is composite number. Example: aa -> True, aaaa -> False (not composite), aab
 * -> False (not only a's)
 */
public class Question1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int acount = 0;
        String str = sc.next();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                acount++;
            }
        }
        if (acount != str.length()) {
            System.out.println(false);
        } else {
            if (isPrimeNumber(acount)) {
                System.out.println(true);
            }else{
                System.out.println(false);
            }
        }

    }

    public static boolean isPrimeNumber(int number) {

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
