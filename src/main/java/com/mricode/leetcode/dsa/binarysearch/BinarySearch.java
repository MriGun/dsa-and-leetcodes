package com.mricode.leetcode.dsa.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
            int [] arr = {-18, -12, -3, 0, 2, 3, 5, 7, 34, 56, 89};
            int target = -18;
            System.out.println(binarySearch(arr, target));
    }

    //return the index

    static int binarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length -1;
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
