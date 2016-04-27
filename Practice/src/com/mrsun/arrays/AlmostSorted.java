package com.mrsun.arrays;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/almost-sorted
 *
 * @author sundechi
 */
public class AlmostSorted {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] d = new int[N];
        for (int i = 0; i < N; i++) {
            d[i] = sc.nextInt();
        }
        for (int i = 0; i < N - 1; i++) {
            if (d[i] > d[i + 1]) {
                int temp = d[i];
                d[i] = d[i + 1];
                d[i + 1] = temp;
            }
            
            if (isSorted(d)) {
                System.out.println("yes");
                System.out.println("swap " + (i + 1) + " " + (i + 2));
            }
        }

    }

    static boolean isSorted(int[] d) {
        for (int i = 0; i < d.length - 1; i++) {
            if (d[i] > d[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
