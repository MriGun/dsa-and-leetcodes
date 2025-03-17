package com.mricode.leetcode.dsa.tree;

import com.mricode.leetcode.dsa.tree.structure.TreeNode;

public class DFS {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter -1;
    }

    int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, dia);

        return Math.max(leftHeight, rightHeight) + 1;
    }


    //https://leetcode.com/problems/invert-binary-tree/description/
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode leftSwap = invertTree(root.left);
        TreeNode rightSwap = invertTree(root.right);

        root.left = rightSwap;
        root.right = leftSwap;

        return root;

    }

    //https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int depth = Math.max(left, right) + 1;

        return depth;
    }


}
