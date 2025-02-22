package com.mricode.leetcode.dsa.tree;

public class AVL {

    private NodeHeight root;

    public int height(NodeHeight node) {

        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public  int height() {
        return root.height;
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

        return rotate(node);
    }

    private NodeHeight rotate(NodeHeight node) {

        if (height(node.left) - height(node.right) > 1) {
            //left heavy
            if (height(node.left.left) - height(node.left.right) > 0) {
                //left left case
                //right rotate on parent node
                return rightRotate(node);
            }

            if (height(node.left.left) - height(node.left.right) < 0) {
                //left right case
                //left rotate on c (children node)
                node.left = leftRotate(node.left);
                //right rotate on original node
                return rightRotate(node);
            }
        }

        if (height(node.left) - height(node.right) < -1) {
            //right heavy
            if (height(node.right.left) - height(node.right.right) < 0) {
                //right right case
                //left rotate on parent node
                return leftRotate(node);
            }

            if (height(node.right.left) - height(node.right.right) > 0) {
                //right left case
                //right rotate on c (children node)
                node.right = rightRotate(node.right);
                //left rotate on original node
                return leftRotate(node);
            }
        }

        return node;
    }

    private NodeHeight rightRotate(NodeHeight p) {
        NodeHeight c = p.left;
        NodeHeight t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return c;
    }


    private NodeHeight leftRotate(NodeHeight c) {
        NodeHeight p = c.right;
        NodeHeight t = p.left;

        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return p;
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

        AVL avl = new AVL();
        int[] nums = {5, 2, 7, 1, 4, 6, 9, 8, 3, 10};

        for (int i = 0; i < 1000; i++) {
            avl.insert(i);
        }

        System.out.println(avl.height());
    }

}
