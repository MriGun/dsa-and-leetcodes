package com.mricode.leetcode.dsa.tree;

import com.mricode.leetcode.dsa.tree.structure.TreeNode;

public class TreeQustions {

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        sortedArrayToBST(nums);
    }

    //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {

        if (start >= end) {
            return null;
        }

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid);
        root.right = sortedArrayToBST(nums, mid + 1, end);

        return root;

    }
}
