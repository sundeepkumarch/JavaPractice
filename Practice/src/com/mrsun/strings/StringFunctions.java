package com.mrsun.strings;

/**
 *
 * @author sundeep
 */
public class StringFunctions {

    void printZigZagConcat(String s, int n) {
        String[] arr = new String[n];
        int len = s.length();
        int row = 0;
        boolean down = true;
        for (int i = 0; i < len; i++) {
            arr[row] += String.valueOf(s.charAt(i))+" ";

            if (row == n - 1) {
                down = false;
            } else if (row == 0) {
                down = true;
            }
            if (down) {
                row++;
            } else {
                row--;
            }
        }
        for (int j = 0; j < n; j++) {
            System.out.println(arr[j]);
        }
    }

    public static void main(String[] args) {
        StringFunctions sf = new StringFunctions();
        sf.printZigZagConcat("SUNDEEP", 2);
    }
}
