package com.mricode.leetcode.dsa.tree.advancequestions;

import com.mricode.leetcode.dsa.tree.structure.TreeNode;

import java.util.PriorityQueue;

public class KthSmallest {

    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
    public int kthSmallest(TreeNode root, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        kthSmallestHelper(root, minHeap, k);

        //remove k elements
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = minHeap.poll();
        }

        return ans;
    }

    private void kthSmallestHelper(TreeNode node, PriorityQueue<Integer> minHeap, int k) {

        if (node == null) {
            return;
        }

        kthSmallestHelper(node.left, minHeap, k);

        minHeap.offer(node.val);

        kthSmallestHelper(node.right, minHeap, k);
    }
}
