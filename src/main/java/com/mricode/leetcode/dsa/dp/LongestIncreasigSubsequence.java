package com.mricode.leetcode.dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasigSubsequence {

    //https://leetcode.com/problems/longest-increasing-subsequence/description/
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int lis[] = new int[n];
        Arrays.fill(lis, 1);

        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int p = 0; p < i; p++) {
                if (nums[p] < nums[i]) {
                    lis[i] = Math.max(lis[i], 1 + lis[p]);
                }
            }
            if (lis[i] > max) {
                max = lis[i];
            }
        }
        return max;
    }

    public int lengthOfLISWithPath(int[] nums) {
        int n = nums.length;
        int lis[] = new int[n];
        int prev[] = new int[n];

        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            prev[i] = i;
        }

        int max = 1;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int p = 0; p < i; p++) {
                if (nums[p] < nums[i]) {
                    if (lis[i] < 1 + lis[p])  {
                        lis[i] = 1 + lis[p];
                        prev[i] = p;
                    }
                    lis[i] = Math.max(lis[i], 1 + lis[p]);
                }
            }
            if (lis[i] > max) {
                max = lis[i];
                maxIndex = i;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[maxIndex]);
        while (maxIndex != prev[maxIndex]) {
           maxIndex = prev[maxIndex];
           list.add(0, nums[maxIndex]); //handling reverse
         }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + ",");
        }

        return max;
    }
}
