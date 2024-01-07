package com.mricode.leetcode.dsa.binarysearch;

public class SplitArrayInLargestValue {
    public static void main(String[] args) {

    }

    public int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;
        for (int i=0; i < nums.length; i++) {
            start = Math.max(start, nums[i]); //max value in the array
            end = end + nums[i]; //sum of the array
        }

        //binary search
        while (start< end) {
            //try for middle as potential answer
            int mid = start + (end - start)/2;

            //calculate how many pieces you can divide with max sum
            int sum = 0;
            int pieces = 1;
            for (int num :nums) {
                if (sum + num > mid) {
                    //you can not add this num in sub array. make new array
                    //say you add this num in new sub array, then sum=num
                    sum=num;
                    pieces++;
                }
                else {
                   sum = sum + num;
                }
            }

            if (pieces > m) {
                start = mid +1;
            }
            else {
                end = mid;
            }

        }
        return end; //start==end
    }
}
