package com.mrsun.questions;

import java.util.Scanner;

/**
 * # # # # # # # # 
 *   # # # # # # #
 *     # # # # # #
 *       # # # # #
 *         # # # #
 *           # # #
 *             # #
 *               #
 */
public class PrintPattern3 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = N; i >= 1; i--) {
            int k = i;
            while(N-k >0){
                sb.append("  ");
                k++;
            }
            k = i;
            while (k > 0) {
                sb.append(" #");
                k--;
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}