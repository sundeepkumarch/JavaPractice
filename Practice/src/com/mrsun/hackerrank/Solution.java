package com.mrsun.hackerrank;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
        String s = "159357lcfd";//in.next();uwpggr
        int k = 98;//in.nextInt();
        StringBuilder sb = new StringBuilder();
        char[] charray = s.toCharArray();
        while (k > 26) {
            k -= 26;
        }
        for (char ch : charray) {
            int index = (int) ch;
            int newindex = 0;
            if (index >= 65 && index <= 90) {
                if ((index + k) > 90) {
                    newindex = 64 + (index + k - 90);
                } else {
                    newindex = index + k;
                }
            } else if (index >= 97 && index <= 122) {
                if ((index + k) > 122) {
                    newindex = 96 + (index + k - 122);
                } else {
                    newindex = index + k;
                }
            } else {
                newindex = index;
            }

            sb.append((char) newindex);
        }
        System.out.println(sb.toString());
    }
}
