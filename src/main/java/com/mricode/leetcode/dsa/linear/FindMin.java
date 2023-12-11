package com.mricode.leetcode.dsa.linear;

public class FindMin {

    public static void main(String[] args) {
        int[] arr = {10, 3, -5, 0, 1, 15, 2};
        System.out.println(findMin(arr));
    }

    private static int findMin(int[] arr) {

        int min = arr[0];
        for (int i=0; i< arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }
}
