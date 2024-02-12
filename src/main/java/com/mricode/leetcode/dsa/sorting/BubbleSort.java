package com.mricode.leetcode.dsa.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
       int[] arr = {5,17,9,2,3,1};
       //int[] arr = {1,2,3,4,5,6};
       //int[] arr = {};
       //bubbleSort(arr);
       selectionSort(arr);
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

    static void selectionSort(int[] arr) {
        for (int i =0; i<arr.length; i++) {
            //find the max item in the remaining array and swap with correct index
            int last = arr.length - i -1;
            int maxIndex= getMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);
        }
    }

    static void swap(int[] arr, int first, int second) {
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;

    }

    static int getMaxIndex(int arr[], int start, int end) {
       int max = start;
        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }
}
