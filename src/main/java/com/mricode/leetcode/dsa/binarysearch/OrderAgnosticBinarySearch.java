package com.mricode.leetcode.dsa.binarysearch;

public class OrderAgnosticBinarySearch {

    public static void main(String[] args) {

        //int [] arr = {-18, -12, -3, 0, 2, 3, 5, 7, 34, 56, 89};
        int [] arr = {99, 80, 75, 22, 11, 10, 5, 2, -3, -9, -10};
        int target = -9;
        System.out.println(orderAgnosticBinarySeearch(arr, target));

    }

    static int orderAgnosticBinarySeearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length -1;

        //find weather the array is sorted in ascending or descending

        boolean isAsc =arr[end] > arr[start];


        while (end >= start) {
            //find the middle element
            //int middle = (start + end) / 2;
            int middle = start + (end -start) / 2;
            if (target == arr[middle]) {
                return middle;
            }
            if (isAsc) {
                if (target > arr[middle]) {
                    start = middle + 1;
                }
                else if (target < arr[middle]) {
                    end = middle - 1;
                }
            }
            else {
                if (target > arr[middle]) {
                    end = middle - 1;

                }
                else if (target < arr[middle]) {
                    start = middle + 1;
                }
            }

        }
        return -1;
    }
}
