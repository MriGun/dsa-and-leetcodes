package com.mricode.leetcode.dsa.binarysearch;

public class MountainArrayPeak {

    //https://leetcode.com/problems/peak-index-in-a-mountain-array/
    public static void main(String[] args) {

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
             else  {     //if (arr[mid] < arr[mid+1])
                 //array is increasing
                 start = mid + 1;
             }
             /*else if (start == end) {
                 return start;
             }*/
         }

         // start and end are always trying to find max element in above 2 checks
        //hence , when they are pointing to just one elemet , this is the max one

        return start; // or end
    }
}
