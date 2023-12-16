package com.mricode.leetcode.dsa.binarysearch;

public class FloorOfNumber {
    public static void main(String[] args) {
        int [] arr = {-18, -12, -3, 0, 2, 3, 5, 7, 34, 56, 89};
        int target = -13;
        int index = floorOfNumber(arr, target);
        int result = index != -1 ? arr[index] : index;
        System.out.println(result);
    }

    //return the index :  greatest number <=target

    static int floorOfNumber(int[] arr, int target) {

        int start = 0;
        int end = arr.length -1;
        while (end >= start) {
            //find the middle element
            //int middle = (start + end) / 2;
            int middle = start + (end -start) / 2;
            if (target == arr[middle]) {
                return middle;
            }
            else if (target > arr[middle]) {
                start = middle + 1;
            }
            else if (target < arr[middle]) {
                end = middle - 1;
            }

        }
        return end;
    }
}
