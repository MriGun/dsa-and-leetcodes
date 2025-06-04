package com.mricode.leetcode.dsa.tree.advancequestions;

import com.mricode.leetcode.dsa.tree.structure.TreeNode;

import java.util.PriorityQueue;

public class KthSmallest {

    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

    private int ans;
    private int k;
    public int kthSmallest(TreeNode root, int k) {

        this.k = k;
        kthSmallestHelper(root);
        return ans;
    }

    private void kthSmallestHelper(TreeNode node) {

        if (node == null) {
            return;
        }

        kthSmallestHelper(node.left);

        k--;
        if (k ==0) {
            ans = node.val;
            return;
        }

        kthSmallestHelper(node.right);
    }
}
