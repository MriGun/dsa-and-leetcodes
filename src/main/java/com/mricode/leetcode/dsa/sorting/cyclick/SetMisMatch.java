package com.mricode.leetcode.dsa.sorting.cyclick;


//https://leetcode.com/problems/set-mismatch/
public class SetMisMatch {

    public static void main(String[] args) {
        int[] arr = {1,2,2,4};
        int[] result = findErrorNums(arr);
        System.out.println(result);
    }

    public static int[] findErrorNums(int[] nums) {
        int i=0;
        while (i<nums.length) {
            int correct = nums[i] -1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            }
            else {
                i++;
            }
        }

        int[] result = new int[2];
        for (int index = 0; index< nums.length; index++) {
            if (nums[index] != index +1) {
                result[0] = nums[index];
                result[1] = index +1;
            }
        }
        return result;
    }

    public static int[] swap(int[] nums, int firstIndex, int secondIndex) {
        int tmp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex]=tmp;
        return nums;
    }


}
