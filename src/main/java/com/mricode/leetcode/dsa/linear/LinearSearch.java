package com.mricode.leetcode.dsa.linear;

public class LinearSearch {

    public static void main(String[] args) {
        int nums[] = {5,7,12,4 ,9,20};

        int target = 4;

        int result = linearSearch(nums, target);


        if (result != -1) {
            System.out.println("Elements found at Index : " + result);
        }
        else {
            System.out.println("Elemts not found!");
        }

        String name = "Mrinmoy";
        System.out.println(searchInString(name,'u'));
        System.out.println(linearSearchInRange(nums,target, 2, 4));

        char stringTarget = 'f';
    }


    private static int linearSearch(int[] nums, int target) {

        if (nums.length ==0) {
            return -1;
        }

        for (int index=0; index<nums.length; index++) {
            if (nums[index] == target) {
                return index;
            }
        }
        return -1;
    }

    private static boolean searchInString(String str, char target) {
        if (str.length() == 0) {
            return false;
        }

        for (int i=0; i<str.length() ; i++) {
            if (str.charAt(i) == target) {
                return true;
            }
        }
        return false;
    }

    private static boolean searchInString2(String str, char target) {
        if (str.length() == 0) {
            return false;
        }

        for (char ch : str.toCharArray()) {
            if (ch == target) {
                return true;
            }
        }
        return false;
    }

    private static int linearSearchInRange(int[] nums, int target, int start, int end) {

        if (nums.length ==0) {
            return -1;
        }

        for (int index=start; index<= end; index++) {
            if (nums[index] == target) {
                return index;
            }
        }
        return -1;
    }
}
