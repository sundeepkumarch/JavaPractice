package com.mrsun.arrays;

/**
 * Merge two sorted arrays such that the initial numbers (after complete
 * sorting) are in the first array and the remaining numbers are in the second
 * array. Extra space allowed in O(1).
 *
 * @author sundeep
 */
public class MergeTwoArrays {

    public static void merge(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int m = arr2.length;

        //Iterate through all elements of ar2[] starting from the last element 
        for (int i = m - 1; i >= 0; i--) {
            int temp = arr1[n - 1];
            int j;
            /* Find the smallest element greater than ar2[i]. Move all
           elements one position ahead till the smallest greater
           element is not found */
            for (j = n - 2; j >= 0 && arr1[j] > arr2[i]; j--) {
                arr1[j + 1] = arr1[j];
            }
            // If there was a greater element
            if (j != n - 1) {
                arr1[j + 1] = arr2[i];
                arr2[i] = temp;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 9, 10, 15, 20};
        int[] arr2 = {2, 3, 8, 13};

        merge(arr1, arr2);

        print(arr1);
        print(arr2);
    }

    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
