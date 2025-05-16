package com.mricode.leetcode.dsa.pattern;

import java.util.Arrays;

public class SqrRootDecompose {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 7, 6, 3, 1, 4, 8};
        int n = arr.length;

        //build block array
        int sqrt = (int) Math.sqrt(n);
        int blocks_id = -1;
        int[] blocks = new int[sqrt + 1];

        for (int i = 0; i < n; i++) {
            //new block is starting
            if (i % sqrt == 0) {
                blocks_id++;
            }
            blocks[blocks_id] += arr[i];
        }

        System.out.println(Arrays.toString(blocks));
        System.out.println(query(blocks, arr, 2, 7, 3));

    }

    public static int query(int[] blocks, int[] arr, int left, int right, int sqrt) {
        int ans = 0;

        //left part
        while (left % sqrt != 0 && left < right && left != 0) {
            ans += arr[left];
            left++;
        }

        //middle part
        while (left + sqrt <= right) {
            ans += blocks[left/sqrt];
            left += sqrt;
        }

        //right part
        while (left <= right) {
            ans += arr[left];
            left++;
        }


        return ans;
    }

    public void update(int[] blocks, int[] arr, int i, int val, int sqrt) {
        int block_id = i / sqrt;
        blocks[block_id] += (val - arr[i]);
        arr[i] = val;
    }
}
