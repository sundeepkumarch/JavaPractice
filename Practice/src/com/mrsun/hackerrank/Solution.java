package com.mrsun.hackerrank;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        //https://www.hackerrank.com/challenges/cavity-map
        Scanner in = new Scanner(System.in);
        int n = 4;//in.nextInt();
        String grid[] = {"1112", "1912", "1892", "1234"};//new String[n];
//        for(int grid_i=0; grid_i < n; grid_i++){
//            grid[grid_i] = in.next();
//        }
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.out.println(grid[i]);
            String[] row = grid[i].split("");
            for(int j = 0; j < n; j++){
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }
        
    }

    /*
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
     */
}
