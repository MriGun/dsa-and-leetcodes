package com.mricode.leetcode.dsa.sorting;


import java.util.Arrays;


//Cyclick sort has to be continous

public class CyclickSort {
    public static void main(String[] args) {
        int[] arr = {4,5,2,3,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        int i=0;
        while (i < arr.length) {
            int correct = arr[i] -1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            }
            else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int first, int second) {
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;

    }
}
