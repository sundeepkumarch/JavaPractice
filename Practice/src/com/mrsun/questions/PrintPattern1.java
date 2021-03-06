package com.mrsun.questions;

import java.util.Scanner;

/**
 * #
 * # #
 * # # #
 * # # # #
 * # # # # #
 * # # # # # #
 * # # # # # # #
 * # # # # # # # #
 * https://www3.ntu.edu.sg/home/ehchua/programming/java/J2a_BasicsExercises.html
 */
public class PrintPattern1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int k = i;
            while (k > 0) {
                sb.append("# ");
                k--;
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
