package com.mrsun.strings;

import java.util.Scanner;

/**
 * https://www.hackerearth.com/capillary-java-coding-challenge/algorithm/ozs-lucky-strings-3/
 *
 * @author sundeep
 */
public class OzsLuckyString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int diff = Math.max(a, b) - Math.min(a, b);
            int offset = (N - 1) * Math.min(a, b);
            int i = 0;
            StringBuffer output = new StringBuffer();
            if (a == b) {
                System.out.println(offset);
            } else {
                while (i <= N - 1) {
                    output.append(offset + (i * diff));
                    output.append(" ");
                    i++;
                }
                System.out.println(output);
            }
        }
    }

    int process(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        int i = 0, j = n - 1;
        int res = 0;
        while (i < j) {
            while ((i < j) && (ch[i] != 'R')) {
                i++;
            }
            while ((j > i) && (ch[j] != 'K')) {
                j--;
            }
            if (i < j) {
                res += 2;
            }
            i++;
            j--;
        }
        return res;
    }
}
