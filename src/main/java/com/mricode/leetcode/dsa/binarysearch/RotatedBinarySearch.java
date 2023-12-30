package com.mricode.leetcode.dsa.binarysearch;

public class RotatedBinarySearch {

    //https://leetcode.com/problems/search-in-rotated-sorted-array/
    public static void main(String[] args) {
      int[] nums = {3, 4,5,6,7,0,1,2};
        System.out.println(findThePivot(nums));
        System.out.println(search(nums, 0));
    }

    static public int search(int[] nums, int target) {
        int pivot = findThePivot(nums);
        //if  pivot is not found, array is not roated

        if (pivot == -1) {
           //just do normal binary search
            return binarySearch(nums, target, 0, nums.length -1);
        }

        //if  pivot is found, we have 2 asc sorted arrays
        if (nums[pivot] == target) {
            return pivot;
        }
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot-1);
        }

        return binarySearch(nums, target, pivot+1, nums.length-1);

    }

    //this will not work for duplicate values
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

    static int binarySearch(int[] arr, int target, int start, int end) {

        /*int start = 0;
        int end = arr.length -1;*/
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
