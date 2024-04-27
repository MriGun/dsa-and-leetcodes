package com.mricode.leetcode.dsa.recursion.arrays;

public class Sorted {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,8,9};
        System.out.println(sorted(arr, 0));
    }

    static boolean sorted(int[] arr, int index) {
        if (index == arr.length -1) {
            return true;
        }
        return arr[index] < arr[index+1] && sorted(arr, index+1);
    }
}
