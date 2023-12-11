package com.mricode.leetcode.dsa.linear;

import java.util.Arrays;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {23, 4, 1},
                {18, 12, 4, 9},
                {45, 71, 39, 16},
                {8, 67}
        };
        
        int target = 67;
        int [] ans = searchIn2DArray(arr, target);
        System.out.println(Arrays.toString(ans));
        System.out.println(maxIn2DArray(arr));
        
    }

    private static int[] searchIn2DArray(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row ++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    return new int[] {row, col};
                }
            }
        }
        return new int[] {-1,-1};
    }

    private static int maxIn2DArray(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int[] ints : arr) {
            for (int col : ints) {
                if (col > max) {
                    max = col;
                }
            }
        }
        return max;
    }
}
