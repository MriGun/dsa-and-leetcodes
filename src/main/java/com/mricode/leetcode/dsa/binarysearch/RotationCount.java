package com.mricode.leetcode.dsa.binarysearch;

public class RotationCount {
    public static void main(String[] args) {
        int[] nums = {3, 4,5,6,7,0,1,2};
        System.out.println(countRotation(nums));
    }

    private static int countRotation(int[] nums) {
        int pivot = findThePivot(nums);
        if (pivot == -1) {
            return 0;
        }
        return pivot+1;
    }

    static int findThePivot(int[] arr) {
        int start = 0;
        int end = arr.length -1;

        while (start <=end) {
            int mid = start + (end -start) /2;
            //4 cases here
            if (mid < end && arr[mid] > arr[mid+1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid-1]) {
                return mid-1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid -1;
            }
            else {
                start = mid +1;
            }
        }
        return -1;
    }

    static int findThePivotWithDuplicate(int[] arr) {
        int start = 0;
        int end = arr.length -1;

        while (start <=end) {
            int mid = start + (end -start) /2;
            //4 cases here
            if (mid < end && arr[mid] > arr[mid+1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid-1]) {
                return mid-1;
            }

            //if elements at middle, start, end equal skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                //skip the duplicates
                //but what if the start and end were the pivot
                //check if start is pivot
                if (arr[start] > arr[start +1]) {
                    return start;
                }
                start++;
                //check if end is pivot
                if (arr[end-1] > arr[end]) {
                    return end-1;
                }
                end--;
            }
            if (arr[start] < arr[mid] || (arr[start] == arr[mid]) && arr[mid] > arr[end]) {
                start = mid +1;
            }
            else {
                end = mid -1;
            }
        }
        return -1;
    }
}
