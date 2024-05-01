package com.mricode.leetcode.dsa.recursion.patterns;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        triangle(4, 0);
        triangle2(4, 0);
        //int[] arr = {4, 3, 2, 1};
        int[] arr = {1, 4, 3, 5};
        //bubbleSort(arr, arr.length-1, 0);
        selectionSort(arr, arr.length, 0,0);
        System.out.println(Arrays.toString(arr));
    }

    static void triangle(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            System.out.print("*");
            triangle(row, col+1);
        }
        else {
            System.out.println();
            triangle(row-1, 0);
        }
    }

    static void triangle2(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {

            triangle2(row, col+1);
            System.out.print("*");

        }
        else {

            triangle2(row-1, 0);
            System.out.println();

        }
    }

    static void bubbleSort(int[] arr, int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {

            if (arr[col] > arr[col+1]) {
                //swap the elements
                int temp = arr[col];
                arr[col] = arr[col+1];
                arr[col+1] = temp;

            }
            bubbleSort(arr, row, col+1);

        }
        else {
            bubbleSort(arr,row-1, 0);
        }
    }

    static void selectionSort(int[] arr, int row, int col, int max) {

        if (row == 0) {
            return;
        }

        if (col < row) {
            if (arr[col] > arr[max]) {
                selectionSort(arr, row, col+1, col);
            }
            else {
                selectionSort(arr, row, col+1, max);
            }

        }
        else {
            //swap the elements
            int temp = arr[max];
            arr[max] = arr[row-1];
            arr[row-1] = temp;

            selectionSort(arr, row-1, 0, 0);
        }
    }
}
