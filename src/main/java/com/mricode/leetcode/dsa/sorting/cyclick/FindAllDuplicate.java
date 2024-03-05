package com.mricode.leetcode.dsa.sorting.cyclick;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
public class FindAllDuplicate {

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer>  result =findDuplicates(arr);
        //System.out.println(Arrays.toString(result));
        System.out.println(result);
    }

    public static List<Integer> findDuplicates(int[] nums) {
          List<Integer> result = new ArrayList<>();
          int i = 0;
          while (i<nums.length) {
              int correct = nums[i] -1;
              if (nums[i] != nums[correct]) {
                  swap(nums, i, correct);
              }
              else {
                  i++;
              }
          }

          for (int index = 0; index< nums.length; index++) {
              if (nums[index] != index +1) {
                  result.add(nums[index]);
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
