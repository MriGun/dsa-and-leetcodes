package com.mricode.leetcode.dsa.recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3, 12, 45, 55, 66, 67};
        int  target = 69;
        System.out.println(binarySearch(arr, target, 0, arr.length-1));
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid  = start + (end - start)/2;

        if (arr[mid] == target) {
            return mid;
        }

        if (target < arr[mid]) {
            return binarySearch(arr, target, start, mid -1);
        }

        return binarySearch(arr, target, mid+1, end);

    }
}
