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

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if (root == null) {
             return null;
         }

         if (root.val == p.val || root.val == q.val) {
             return root;
         }

         TreeNode left = lowestCommonAncestor(root.left, p, q);
         TreeNode right = lowestCommonAncestor(root.right, p, q);

         if (left != null && right != null) {
             return root;
         }

         if (left == null && right != null) {
             return right;
         }
         else {
             return left;
         }
    }

    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/

    int counter = 0;
     public int kthSmallest(TreeNode root, int k) {
        return kthSmallestHelper(root, k).val;
     }

    public TreeNode kthSmallestHelper(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        TreeNode left = kthSmallestHelper(root.left, k);

        if (left != null) {
            return left;
        }

        counter++;

        if (counter == k) {
            return root;
        }

        return kthSmallestHelper(root.right, k);
    }





}
