package com.mricode.leetcode.dsa.recursion.arrays;

import java.util.ArrayList;

public class Find {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,5,7};
        System.out.println(findIndex(arr, 8, 0));
        System.out.println(findIndexLast(arr, 3, arr.length-1));
        findAllIndex(arr, 5, 0);
        ArrayList<Integer> list2 = new ArrayList<>();
        findAllIndex2(arr, 7, 0, list2);
        System.out.println(list);
        System.out.println(list2);
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

    static ArrayList<Integer> list = new ArrayList<>();
    static void findAllIndex(int[] arr, int target, int index) {

        if (index == arr.length) {
            return;
        }

        if (arr[index] == target) {
            list.add(index);
        }

        findAllIndex(arr, target, index+1);

    }

    static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index, ArrayList<Integer> list) {

        if (index == arr.length) {
            return list;
        }

        if (arr[index] == target) {
            list.add(index);
        }

        return findAllIndex2(arr, target, index+1, list);

    }

 }
