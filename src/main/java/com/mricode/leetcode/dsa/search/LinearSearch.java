package com.mricode.leetcode.dsa.search;

public class LinearSearch {

    public static void main(String[] args) {
        int nums[] = {5,7,12,4 ,9,20};

        int target = 5;

        int result = linearSearch(nums, target);


        if (result != -1) {
            System.out.println("Elements found at Index : " + result);
        }
        else {
            System.out.println("Elemts not found!");
        }
    }


    private static int linearSearch(int[] nums, int target) {

        if (nums.length ==0) {
            return -1;
        }

        for (int index=0; index<nums.length; index++) {
            if (nums[index] == target) {
                return index;
            }
        }
        return -1;
    }
}
