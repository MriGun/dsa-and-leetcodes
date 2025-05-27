package com.mricode.leetcode.dsa.tree.advancequestions;

import com.mricode.leetcode.dsa.tree.structure.TreeNode;

import java.util.HashSet;

public class TwoSum {

    //https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return findTargetHelper(root, k, set);
    }

    private boolean findTargetHelper(TreeNode node, int k, HashSet<Integer> set) {
        if (node == null) {
            return false;
        }

        if (set.contains(k - node.val)) {
            return true;
        }

        set.add(node.val);

        return findTargetHelper(node.left, k, set) || findTargetHelper(node.right, k, set);
    }
}
