package com.mricode.leetcode.dsa.sorting;

import java.util.Arrays;

public class CountSort {

    public static void countSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int[] countArray = new int[max+1];

        //creating frequency array
        for (int num : arr) {
            countArray[num]++;
        }

        int index = 0;
        for(int i=0; i < max; i++) {
            while (countArray[i] > 0) {
                arr[index] = i;
                index++;
                countArray[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 10, 9, 2, 4, 9, 7};
        countSort(arr);
        System.out.println(Arrays.toString(arr));

    }

}
