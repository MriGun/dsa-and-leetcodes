package com.mricode.leetcode.dsa.recursion.arrays;

public class Find {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,8,9};
        System.out.println(findIndex(arr, 8, 0));
        System.out.println(findIndexLast(arr, 3, arr.length-1));
    }

    static boolean find(int[] arr, int target, int index) {

        if (index == arr.length -1) {
            return false;
        }

        return arr[index] == target || find(arr, target, index+1);

    }

    static int findIndex(int[] arr, int target, int index) {

        if (index == arr.length -1) {
            return -1;
        }

        if (arr[index] == target) {
            return index;
        }

        return findIndex(arr, target, index+1);

    }

    static int findIndexLast(int[] arr, int target, int index) {

        if (index == -1) {
            return -1;
        }

        if (arr[index] == target) {
            return index;
        }
        else {
            return findIndexLast(arr, target, index-1);
        }
    }

 }
