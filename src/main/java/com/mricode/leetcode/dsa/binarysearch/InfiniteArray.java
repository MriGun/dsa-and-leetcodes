package com.mricode.leetcode.dsa.binarysearch;

public class InfiniteArray {

    //https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 9, 10, 90, 100, 130,
                140, 160, 170};

        int target = 10;
        System.out.println(findInRange(arr, target));
    }

    static  int findInRange(int[] arr, int target) {
        //first find the range
        //start with the box of size 2

        int start = 0;
        int end = 1;

        // condition for the target to lie in the range

        while (target > arr[end]) {
            int newStart = end + 1;
            //double the box value
            //end = previous end + size of box*2
            end = end + (end -start + 1) * 2;
            start = newStart;
        }
        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {

        while (end >= start) {
            //find the middle element
            //int middle = (start + end) / 2;
            int middle = start + (end -start) / 2;
            if (target == arr[middle]) {
                return middle;
            }
            else if (target > arr[middle]) {
                start = middle + 1;
            }
            else if (target < arr[middle]) {
                end = middle - 1;
            }
            else {
                return -1;
            }
        }
        return -1;
    }
}
