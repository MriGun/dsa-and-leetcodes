package com.mricode.leetcode.dsa.linear;

public class EvenNumberOfDigits1295 {

    //https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
           String num = String.valueOf(nums[i]);
            if (num.length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
