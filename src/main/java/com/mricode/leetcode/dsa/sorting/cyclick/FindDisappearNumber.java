package com.mricode.leetcode.dsa.sorting.cyclick;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
//google question
public class FindDisappearNumber {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer>  result =findDisappearedNumbers(arr);
        //System.out.println(Arrays.toString(result));
        System.out.println(result);
    }

    static List<Integer>  findDisappearedNumbers(int[] nums) {
         int i = 0;
         List<Integer> result = new ArrayList<Integer>();

         while (i<nums.length) {
             int correct = nums[i]-1;
             if (nums[i] != nums[correct]) {
                 swap(nums, i, correct);
             }
             else {
                 i++;
             }
         }

         for (int index=0; index<nums.length; index++) {
             if (nums[index] != index+1) {
                 //result[resultIndex] = index+1;
                 result.add(index+1);
             }
         }

         return result;

    }

    static void swap(int[] arr, int first, int second) {
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;

    }
}
