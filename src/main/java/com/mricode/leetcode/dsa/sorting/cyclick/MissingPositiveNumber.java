package com.mricode.leetcode.dsa.sorting.cyclick;

import java.util.Arrays;


//https://leetcode.com/problems/first-missing-positive/description/

//Hints
//Ignore negetive number and the elements greater than the length of array
public class MissingPositiveNumber {

    public static void main(String[] args) {
        int[] arr = {1,2,0};
        int missingNumber = firstMissingPositive(arr);
        System.out.println(missingNumber);
    }
    public static int firstMissingPositive(int[] nums) {
        int i=0;
        while (i < nums.length) {
            int correctIndex = nums[i] -1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            }
            else {
                i++;
            }
        }
        //search for missing number
        for (int index=0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                return index + 1;
            }
        }

        //case 2
        return nums.length + 1;
    }

    static void swap(int[] arr, int first, int second) {
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;

    }

}
