package com.mricode.leetcode.dsa.tree.advancequestions;

import com.mricode.leetcode.dsa.tree.structure.TreeNode;

import java.util.HashMap;

public class BinarytreeFromPreAndInOrder {

    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        int[] index = {0};

        return buildTreeHelper(preorder, inorder, 0, preorder.length-1, map, index);

    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right, HashMap<Integer, Integer> map, int[] index) {

        if (left > right) {
            return null;
        }

        int current = preorder[index[0]];
        index[0]++;

        TreeNode node = new TreeNode(current);

        if (left == right) {
            return node;
        }

        int inorderIndex = map.get(current);

        node.left = buildTreeHelper(preorder, inorder, left, inorderIndex-1, map, index);
        node.right = buildTreeHelper(preorder, inorder, inorderIndex+1, right, map, index);

        return node;
    }

}
