package com.mrsun.arrays;

/**
 *
 * @author sundeep
 */
public class LargeMultiplication {

    public static void main(String[] args) {
        int[] Num1 = {5, 3, 6, 2, 8, 2, 0, 2, 8};
        int[] Num2 = {3, 5, 2, 3, 2, 1, 3, 4};
        int sum = 0, carry;
        int k = Num1.length + Num2.length;
        int[] Num = new int[k];
        for (int i = Num1.length - 1; i >= 0; i--) {
            carry = 0;
            for (int j = Num2.length - 1; j >= 0; j--) {
                sum = Num2[j] * Num1[i] + carry + Num[k - 1];
                carry = sum / 10;
                Num[--k] = sum % 10;

            }
            Num[--k] = carry;
            k += Num2.length;
        }

        for (int j = 0; j < Num.length; j++) {
            System.out.print(Num[j]);
        }
    }
}
