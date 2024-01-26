package com.mricode.leetcode.dsa.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
       //int[] arr = {5,17,9,2,3,1};
       //int[] arr = {1,2,3,4,5,6};
       int[] arr = {};
       bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr) {

        boolean isSwapped=false;

        //run steps n-1 times
        for (int i=0; i< arr.length; i++) {
            //for each step max num will come at last index
            System.out.println(arr.length);
            for (int j = 1; j < arr.length -i; j++) {
                //swap if the item is smaller than previous item
                if (arr[j] < arr[j-1]) {
                   //swap
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }
}
