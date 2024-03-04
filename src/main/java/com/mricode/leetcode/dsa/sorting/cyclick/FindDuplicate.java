package com.mricode.leetcode.dsa.sorting.cyclick;

import java.util.List;

class FindDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        int result =findDuplicate(arr);
        //System.out.println(Arrays.toString(result));
        System.out.println(result);
    }
    public static int findDuplicate(int[] nums) {
        int i=0;
        while (i < nums.length) {
           if (nums[i] != i+1) {
               int correct = nums[i] -1;
               if (nums[i] != nums[correct]) {
                   swap(nums, i, correct);
               }
               else {
                   return nums[i];
               }
           }
           else {
               i++;
           }
        }
        return -1;
    }

    static void swap(int[] arr, int first, int second) {
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;

    }
}