package com.mricode.leetcode.dsa.binarysearch;

public class CeilingOfNumber {
    public static void main(String[] args) {
        int [] arr = {-18, -12, -3, 0, 2, 3, 5, 7, 34, 56, 89};
        int target = 90;
        int index = ceilingOfNumber(arr, target);
        int result = index != -1 ? arr[index] : index;
        System.out.println(result);
    }

    //return the index :  smallest number >= target

    static int ceilingOfNumber(int[] arr, int target) {

        if (target > arr[arr.length -1]) {
            return -1;
        }

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

        }
        return start;
    }
}
