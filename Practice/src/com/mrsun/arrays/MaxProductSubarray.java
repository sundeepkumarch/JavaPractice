package com.mrsun.arrays;

/**
 *
 * @author sundechi
 */
public class MaxProductSubarray {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 0, 7, 8, 2};
        int current_max = 1;
        int current_min = 0;
        int start_index = 0;
        int end_index = 0;
        int max = 1;

        for (int i = 0; i < input.length; i++) {
            if (input[i] > 0) {
                current_max = current_max * input[i];
                max = max > current_max ? max : current_max;
                end_index = i;
            } else {
                current_max = 1;
                start_index = i+1;
                end_index = i;
            }
        }
        System.out.println("Max:" + max);
        System.out.println("Start:"+start_index+" End:"+end_index);
    }
}
