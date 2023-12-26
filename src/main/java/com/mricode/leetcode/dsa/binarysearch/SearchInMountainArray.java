package com.mricode.leetcode.dsa.binarysearch;

public class SearchInMountainArray {

    //https://leetcode.com/problems/find-in-mountain-array/description/

    public static void main(String[] args) {

    }

    int search(int[] arr, int target) {
        int peak =peakIndexInMountainArray(arr);
        int firstTry = orderAgnosticBinarySeearch(arr ,target, 0, peak);
        if (firstTry != -1) {
            return firstTry;
        }
        return  orderAgnosticBinarySeearch(arr ,target, peak +1, arr.length -1);
    }


    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length -1;

        while (end > start) {
            int mid = start + (end -start) /2;

            if (arr[mid] > arr[mid+1]) {
                //array is decreasing
                //this may be the ans , but look at left
                //this is why end != mid -1
                end = mid;
            }
            else  {
                //array is increasing
                start = mid + 1;
            }
        }

        // start and end are always trying to find max element in above 2 checks
        //hence , when they are pointing to just one elemet , this is the max one

        return start; // or end
    }

    static int orderAgnosticBinarySeearch(int[] arr, int target, int start , int end) {

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
