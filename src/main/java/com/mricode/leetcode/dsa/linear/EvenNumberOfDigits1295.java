package com.mricode.leetcode.dsa.linear;

public class EvenNumberOfDigits1295 {

    //https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        System.out.println(findNumbers2(nums));
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

    public static int findNumbers2(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (even(num)) {
                count++;
            }
        }
        return count;
    }

    public static boolean even(int num) {
        int numOfDigits = countDigits2(num);
        if (numOfDigits % 2 == 0) {
            return true;
        }
        return false;
    }

    private static int countDigits(int num) {

        if (num < 0) {
            num = num * -1;
        }

        if (num == 0) {
            return 1;
        }

        int count = 0;
        while (num > 0) {
            count++;
            num = num/10;
        }
        return count;
    }

    private static int countDigits2(int num) {
        if (num < 0) {
            num = num * -1;
        }
        return (int)(Math.log10(num)) + 1;
    }
}
