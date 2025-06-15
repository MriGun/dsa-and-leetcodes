package com.mricode.leetcode.dsa.tree.advancequestions;


import com.mricode.leetcode.dsa.tree.structure.TreeNode;

public class NodeSwaped {

    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void helper(TreeNode root) {

        inOrderTraversal(root);

        //swap
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inOrderTraversal(TreeNode node) {

        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);

        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }

        prev  = node;

        inOrderTraversal(node.right);
    }
}
