package com.mricode.leetcode.dsa.binarysearch;

public class FirstAndLastPosition {


    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int[] answer = {-1, -1};

        //check for first occurance if target first
        answer[0] = search(nums, target, true);

        if (answer[0] != -1) {
            answer[1]= search(nums, target, false);
        }

        return answer;
    }

    //this function just returns the index value of target

    int search(int[] nums, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length -1;
        while (end >= start) {
            //find the middle element
            //int middle = (start + end) / 2;
            int middle = start + (end -start) / 2;
            if (target == nums[middle]) {
                //potential ans found!
                ans = middle;
                if (findStartIndex) {
                     end = middle -1;
                }
                else {
                    start = middle + 1;
                }
            }
            else if (target > nums[middle]) {
                start = middle + 1;
            }
            else if (target < nums[middle]) {
                end = middle - 1;
            }

        }
        return ans;
    }
}
