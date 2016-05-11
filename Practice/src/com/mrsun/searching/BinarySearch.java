package com.mrsun.searching;

/**
 *
 * @author sundeep
 */
public class BinarySearch {

    public int binarySearch(int[] arr, int low, int high, int x) {
        if (high >= low) {
            int mid = (high + low) / 2;

            /* Check if arr[mid] is the first occurrence of x.
            arr[mid] is first occurrence if x is one of the following
            is true:
            (i)  mid == 0 and arr[mid] == x
            (ii) arr[mid-1] < x and arr[mid] == x
             */
            if (arr[mid] == x) {
                return mid;
            } else if (x > arr[mid]) {
                return binarySearch(arr, mid + 1, high, x);
            } else {
                return binarySearch(arr, 0, mid - 1, x);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = {1, 2, 3, 5, 7, 9};
        int x = 10;
        if (bs.binarySearch(arr, 0, arr.length - 1, x) == -1) {
            System.out.println("Not Found!!");
        } else {
            System.out.println("Found!!");
        }

    }
}
