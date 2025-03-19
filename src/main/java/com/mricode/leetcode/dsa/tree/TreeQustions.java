package com.mricode.leetcode.dsa.tree;

import com.mricode.leetcode.dsa.tree.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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


    //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
    Queue<TreeNode> queue = new LinkedList<>();
    public void flatten(TreeNode root) {

        TreeNode newNode = preOrder(root);

        TreeNode rootNode = queue.poll();

         while (!queue.isEmpty()){
             rootNode.left = null;
             TreeNode rightNode = queue.poll();

             rootNode.right = rightNode;
             if (rightNode != null) {
                 rootNode = rightNode;
             }

         }

    }

     TreeNode preOrder(TreeNode node) {
        if (node == null) {
            return null;
        }
        queue.add(node);

        preOrder(node.left);
        preOrder(node.right);
        return node;
    }
}
