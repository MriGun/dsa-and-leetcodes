package com.mricode.leetcode.dsa.tree;

public class BinarySearchTree {

    private NodeHeight root;

    public int height(NodeHeight node) {

        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        display(root, "Root Mode : ");
    }

    private void display(NodeHeight node, String details) {
        if (node ==null) {
            return;
        }

        System.out.println(details + node.val);

        display(node.left, "Left child of " + node.val + " : ");
        display(node.right, "Right child of " + node.val + " : ");
    }

    public void insert(int value) {
       root = insert(value, root);
    }

    private NodeHeight insert(int value, NodeHeight node) {

        if (node == null) {
            node = new NodeHeight(value);
            return node;
        }

        if (value < node.val) {
            node.left = insert(value, node.left);
        }

        if (value > node.val) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(NodeHeight node) {

        if (node == null) {
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <=1 && balanced(node.left) && balanced(node.right);

    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void populatedSorted(int[] nums) {
        populatedSorted(nums, 0, nums.length);
    }

    private void populatedSorted(int[] nums, int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        this.insert(nums[mid]);
        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid + 1, end);

    }

    public void displayWithHeight() {
        display(this.root, "Root Node : ");
    }

    private void displayWithHeight(NodeHeight node, String details) {

        if (node == null) {
            return;
        }

        System.out.println(details + node.val);
        displayWithHeight(node.left, "Left child of " + node.val + " : ");
        displayWithHeight(node.right, "Right child of " + node.val + " : ");

    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        int[] nums = {5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
        bst.populate(nums);
        bst.display();
    }

}
